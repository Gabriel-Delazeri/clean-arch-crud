package com.delazeri.cleanarch.infrastructure.persistence.jpa;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MusicEntity {
    @Id
    private Long id;
    private String name;
    private String slug;
    private String imageUrl;
    private String artistName;
    private Long durationMs;

    public MusicEntity(String name, String slug, String imageUrl, String artistName, Long durationMs) {
        this.name = name;
        this.slug = slug;
        this.imageUrl = imageUrl;
        this.artistName = artistName;
        this.durationMs = durationMs;
    }
}
