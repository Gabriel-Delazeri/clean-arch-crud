package com.delazeri.cleanarch.infrastructure.controllers.responses;

public record CreateMusicResponse(
        String name,
        String slug,
        String imageUrl,
        String artistName,
        Long durationMs
) {
}
