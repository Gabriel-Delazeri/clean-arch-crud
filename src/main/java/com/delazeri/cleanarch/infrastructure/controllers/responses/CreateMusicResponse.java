package com.delazeri.cleanarch.infrastructure.controllers.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateMusicResponse(
        String name,
        String slug,
        @JsonProperty(value = "image_url") String imageUrl,
        @JsonProperty(value = "artist_name") String artistName,
        @JsonProperty(value = "duration_ms") Long durationMs
) {
}
