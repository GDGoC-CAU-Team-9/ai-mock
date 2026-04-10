package com.gdg_team9.aimock.controller;

import com.gdg_team9.aimock.dto.AvoidIntakeRequest;
import com.gdg_team9.aimock.dto.RankRequest;
import com.gdg_team9.aimock.service.AiMockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class AiMockController {

    private final AiMockService aiMockService;

    @PostMapping(value = "/rank", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> rank(@RequestBody(required = false) RankRequest request) {
        return aiMockService.rank(request);
    }

    @PostMapping(value = "/avoid/intake", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> avoidIntake(@RequestBody(required = false) AvoidIntakeRequest request) {
        return aiMockService.avoidIntake(request);
    }
}
