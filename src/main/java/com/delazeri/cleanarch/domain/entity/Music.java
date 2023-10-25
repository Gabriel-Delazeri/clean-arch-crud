package com.delazeri.cleanarch.domain.entity;

public record Music(
        String name,
        String slug,
        String imageUrl,
        String artistName,
        Long durationMs
) {
}
