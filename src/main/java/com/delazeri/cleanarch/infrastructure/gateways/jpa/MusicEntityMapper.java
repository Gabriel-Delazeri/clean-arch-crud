package com.delazeri.cleanarch.infrastructure.gateways.jpa;

import com.delazeri.cleanarch.domain.entity.Music;
import com.delazeri.cleanarch.infrastructure.persistence.jpa.MusicEntity;

public class MusicEntityMapper {

    public Music entityToDomainObj(MusicEntity musicEntity) {
        return new Music(
                musicEntity.getName(),
                musicEntity.getSlug(),
                musicEntity.getImageUrl(),
                musicEntity.getArtistName(),
                musicEntity.getDurationMs()
        );
    }

    public MusicEntity domainObjToEntity(Music musicDomainObj) {
        return new MusicEntity(
                musicDomainObj.name(),
                musicDomainObj.slug(),
                musicDomainObj.imageUrl(),
                musicDomainObj.artistName(),
                musicDomainObj.durationMs()
        );
    }
}
