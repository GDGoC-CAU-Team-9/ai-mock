package com.gdg_team9.aimock.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AvoidIntakeRequest(
        @JsonProperty("user_text")
        String userText,

        String lang
) {
}
