package com.delazeri.cleanarch.infrastructure.persistence.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MusicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
