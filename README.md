# AI Mock Server (WebFlux)

Spring WebFlux 기반 AI 대체(Mock) 서버입니다.
동시에 많은 요청이 들어올 때도 스레드를 블로킹하지 않고, 설정된 지연 시간 후 고정 응답을 반환합니다.

## Endpoints

- `POST /rank`
- `POST /avoid/intake`

## Example Request/Response

### 1) `POST /rank`

Request

```json
{
  "image_url": "https://example.com/menu.jpg",
  "menu_lang": "ko",
  "presigned_url": "https://example.com/presigned-upload-url",
  "avoid": [
    "우유",
    "대두"
  ],
  "lang": "ko"
}
```

Response (default)

```json
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
```

### 2) `POST /avoid/intake`

Request

```json
{
  "user_text": "저는 우유 알레르기가 있어요. 그리고 커피도 마시면 안 돼요.",
  "lang": "ko"
}
```

Response (default)

```json
{
  "candidates": [
    "유제품",
    "커피",
    "치즈"
  ],
  "confirm_question": "이 음식들을 피해야 할까요?"
}
```

## Configuration

`src/main/resources/application.yml`

- `mock-ai.rank.delay-ms`: `/rank` 응답 지연(ms)
- `mock-ai.avoid-intake.delay-ms`: `/avoid/intake` 응답 지연(ms)

## Run

```powershell
./gradlew.bat bootRun
```

## Test

```powershell
./gradlew.bat test
```

