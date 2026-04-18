package com.gdg_team9.aimock;

import com.gdg_team9.aimock.dto.AvoidIntakeRequest;
import com.gdg_team9.aimock.dto.RankRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {
        "mock-ai.rank.delay-ms=80",
        "mock-ai.avoid-intake.delay-ms=120"
})
class AimockApplicationTests {

    @LocalServerPort
    private int port;

    private WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
        this.webTestClient = WebTestClient.bindToServer()
                .baseUrl("http://localhost:" + port)
                .build();
    }

    @Test
    void rankEndpointReturnsJsonAfterDelay() {
        long start = System.nanoTime();

        webTestClient.post()
                .uri("/rank")
                .bodyValue(new RankRequest(
                        "https://example.com/menu.jpg",
                        "ko",
                        "https://example.com/presigned-url",
                        List.of("우유", "대두"),
                        "ko"
                ))
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.best.menu").exists()
                .jsonPath("$.best.risk").isNumber()
                .jsonPath("$.items").isArray()
                .jsonPath("$.timings_ms.total").isNumber();

        long elapsedMs = (System.nanoTime() - start) / 1_000_000;
        assertThat(elapsedMs).isGreaterThanOrEqualTo(80);
    }

    @Test
    void avoidIntakeEndpointReturnsJsonAfterDelay() {
        long start = System.nanoTime();

        webTestClient.post()
                .uri("/avoid/intake")
                .bodyValue(new AvoidIntakeRequest("유제품과 카페인을 피하고 싶어요", "ko"))
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.candidates").isArray()
                .jsonPath("$.confirm_question").isEqualTo("이 음식들을 피해야 할까요?");

        long elapsedMs = (System.nanoTime() - start) / 1_000_000;
        assertThat(elapsedMs).isGreaterThanOrEqualTo(120);
    }
}
