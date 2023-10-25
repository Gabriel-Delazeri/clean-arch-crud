package com.delazeri.cleanarch.infrastructure.controllers.requests;

public record CreateMusicRequest(
        String name,
        String slug,
        String imageUrl,
        String artistName,
        Long durationMs
) {
}
