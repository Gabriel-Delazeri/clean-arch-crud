package com.delazeri.cleanarch.infrastructure.controllers.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MusicResponse(
        String name,
        String slug,
        @JsonProperty(value = "image_url") String imageUrl,
        @JsonProperty(value = "artist_name") String artistName,
        @JsonProperty(value = "duration_ms") Long durationMs
) {
}
