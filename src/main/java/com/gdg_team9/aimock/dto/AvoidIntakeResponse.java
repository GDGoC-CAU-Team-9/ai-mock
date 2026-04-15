package com.gdg_team9.aimock.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record AvoidIntakeResponse(
        List<String> candidates,

        @JsonProperty("confirm_question")
        String confirmQuestion
) {
}
