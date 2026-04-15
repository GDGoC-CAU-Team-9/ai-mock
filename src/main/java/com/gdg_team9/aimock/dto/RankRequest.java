package com.gdg_team9.aimock.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record RankRequest(
        @JsonProperty("image_url")
        String imageUrl,

        @JsonProperty("menu_lang")
        String menuLang,

        @JsonProperty("presigned_url")
        String presignedUrl,

        List<String> avoid,

        String lang
) {
}
