package com.gdg_team9.aimock.service;

import com.gdg_team9.aimock.dto.AvoidIntakeRequest;
import com.gdg_team9.aimock.dto.RankRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class AiMockService {

    @Value("${mock-ai.rank.delay-ms:800}")
    private long rankDelayMs;

    private final String rankResponse = """
            {
                "best": {
                    "menu": "붉은 대게 솥밥",
                    "risk": 12,
                    "score": 88,
                    "reason": "뚜렷한 기피 재료는 확인되지 않았어요. 다만 정보가 부족해 점수는 보수적으로 계산했어요.",
                    "confidence": 0.85,
                    "matched_avoid": [],
                    "menu_original": "붉은 대게 솥밥",
                    "suspected_ingredients": [
                        "게",
                        "밀"
                    ]
                },
                "items": [
                    {
                        "menu": "붉은 대게 솥밥",
                        "risk": 12,
                        "score": 88,
                        "reason": "뚜렷한 기피 재료는 확인되지 않았어요. 다만 정보가 부족해 점수는 보수적으로 계산했어요.",
                        "confidence": 0.85,
                        "matched_avoid": [],
                        "menu_original": "붉은 대게 솥밥",
                        "suspected_ingredients": [
                            "게",
                            "밀"
                        ]
                    },
                    {
                        "menu": "고 퀄리티 솥밥",
                        "risk": 17,
                        "score": 83,
                        "reason": "뚜렷한 기피 재료는 확인되지 않았어요. 다만 정보가 부족해 점수는 보수적으로 계산했어요.",
                        "confidence": 0.8,
                        "matched_avoid": [],
                        "menu_original": "고 퀄리티 솥밥",
                        "suspected_ingredients": [
                            "글루텐",
                            "돼지고기"
                        ]
                    },
                    {
                        "menu": "소고기 스키야키",
                        "risk": 17,
                        "score": 83,
                        "reason": "뚜렷한 기피 재료는 확인되지 않았어요. 다만 정보가 부족해 점수는 보수적으로 계산했어요.",
                        "confidence": 0.8,
                        "matched_avoid": [],
                        "menu_original": "소고기 스키야키",
                        "suspected_ingredients": [
                            "소고기",
                            "참깨",
                            "밀"
                        ]
                    },
                    {
                        "menu": "참 도미 솥밥",
                        "risk": 19,
                        "score": 81,
                        "reason": "뚜렷한 기피 재료는 확인되지 않았어요. 다만 정보가 부족해 점수는 보수적으로 계산했어요.",
                        "confidence": 0.7,
                        "matched_avoid": [],
                        "menu_original": "참 도미 솥밥",
                        "suspected_ingredients": [
                            "생선",
                            "밀"
                        ]
                    },
                    {
                        "menu": "대창 전골",
                        "risk": 21,
                        "score": 79,
                        "reason": "주의: 우유 (약한 추론, p=0.07)",
                        "confidence": 0.2025,
                        "matched_avoid": [
                            "우유"
                        ],
                        "menu_original": "대창 전골",
                        "suspected_ingredients": [
                            "돼지고기",
                            "버터",
                            "우유"
                        ]
                    },
                    {
                        "menu": "매콤 쭈꾸미",
                        "risk": 21,
                        "score": 79,
                        "reason": "주의: 두부 (약한 추론, p=0.08)",
                        "confidence": 0.25,
                        "matched_avoid": [
                            "대두"
                        ],
                        "menu_original": "매콤 쭈꾸미",
                        "suspected_ingredients": [
                            "새우",
                            "대두"
                        ]
                    },
                    {
                        "menu": "간장 제육",
                        "risk": 22,
                        "score": 78,
                        "reason": "주의: 두부 (약한 추론, p=0.09)",
                        "confidence": 0.25,
                        "matched_avoid": [
                            "대두"
                        ],
                        "menu_original": "간장 제육",
                        "suspected_ingredients": [
                            "돼지고기",
                            "대두"
                        ]
                    },
                    {
                        "menu": "토시 스테이크 솥밥",
                        "risk": 22,
                        "score": 78,
                        "reason": "주의: 우유 (약한 추론, p=0.09)",
                        "confidence": 0.25,
                        "matched_avoid": [
                            "우유"
                        ],
                        "menu_original": "토시 스테이크 솥밥",
                        "suspected_ingredients": [
                            "생선",
                            "밀",
                            "버터",
                            "소고기",
                            "우유"
                        ]
                    },
                    {
                        "menu": "소주",
                        "risk": 23,
                        "score": 77,
                        "reason": "뚜렷한 기피 재료는 확인되지 않았어요. 다만 정보가 부족해 점수는 보수적으로 계산했어요.",
                        "confidence": 0.9,
                        "matched_avoid": [],
                        "menu_original": "소주",
                        "suspected_ingredients": [
                            "밀"
                        ]
                    },
                    {
                        "menu": "영양 버섯 솥밥",
                        "risk": 29,
                        "score": 71,
                        "reason": "뚜렷한 기피 재료는 확인되지 않았어요. 다만 정보가 부족해 점수는 보수적으로 계산했어요.",
                        "confidence": 0.55,
                        "matched_avoid": [],
                        "menu_original": "영양 버섯 솥밥",
                        "suspected_ingredients": [
                            "밀"
                        ]
                    },
                    {
                        "menu": "연태 / 자몽 / 얼그레이 하이볼 500ml",
                        "risk": 32,
                        "score": 68,
                        "reason": "뚜렷한 기피 재료는 확인되지 않았어요. 다만 정보가 부족해 점수는 보수적으로 계산했어요.",
                        "confidence": 0.7,
                        "matched_avoid": [],
                        "menu_original": "연태 / 자몽 / 얼그레이 하이볼 500ml",
                        "suspected_ingredients": [
                            "밀"
                        ]
                    },
                    {
                        "menu": "병 맥주 500ml",
                        "risk": 59,
                        "score": 41,
                        "reason": "뚜렷한 기피 재료는 확인되지 않았어요. 다만 정보가 부족해 점수는 보수적으로 계산했어요.",
                        "confidence": 0.1,
                        "matched_avoid": [],
                        "menu_original": "병 맥주 500ml",
                        "suspected_ingredients": []
                    },
                    {
                        "menu": "콜라 / 사이다 355ml",
                        "risk": 62,
                        "score": 38,
                        "reason": "뚜렷한 기피 재료는 확인되지 않았어요. 다만 정보가 부족해 점수는 보수적으로 계산했어요.",
                        "confidence": 0.05,
                        "matched_avoid": [],
                        "menu_original": "콜라 / 사이다 355ml",
                        "suspected_ingredients": []
                    }
                ],
                "timings_ms": {
                    "total": 44739,
                    "extract": 16666,
                    "image_load": 3397,
                    "risk_assess": 18132,
                    "score_policy": 24
                },
                "items_extracted": [
                    "소고기 스키야키",
                    "토시 스테이크 솥밥",
                    "매콤 쭈꾸미",
                    "간장 제육",
                    "대창 전골",
                    "붉은 대게 솥밥",
                    "영양 버섯 솥밥",
                    "병 맥주 500ml",
                    "참 도미 솥밥",
                    "콜라 / 사이다 355ml",
                    "고 퀄리티 솥밥",
                    "소주",
                    "연태 / 자몽 / 얼그레이 하이볼 500ml"
                ]
            }
            """;

    @Value("${mock-ai.avoid-intake.delay-ms:1200}")
    private long avoidDelayMs;

    private final String avoidIntakeResponse = """
            {
                "candidates": ["유제품", "커피", "치즈"],
                "confirm_question": "이 음식들을 피해야 할까요?"
            }
            """;

    public Mono<String> rank(RankRequest request) {
        return Mono.delay(Duration.ofMillis(rankDelayMs))
                .map(ignored -> rankResponse);
    }

    public Mono<String> avoidIntake(AvoidIntakeRequest request) {
        return Mono.delay(Duration.ofMillis(avoidDelayMs))
                .map(ignored -> avoidIntakeResponse);
    }
}
