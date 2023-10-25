package com.delazeri.cleanarch.infrastructure.gateways.jpa;

import com.delazeri.cleanarch.application.gateways.MusicGateway;
import com.delazeri.cleanarch.domain.entity.Music;
import com.delazeri.cleanarch.infrastructure.persistence.jpa.MusicEntity;
import com.delazeri.cleanarch.infrastructure.persistence.jpa.MusicRepository;
import org.springframework.stereotype.Service;

@Service
public class MusicRepositoryGateway implements MusicGateway {
    private final MusicRepository musicRepository;
    private final MusicEntityMapper musicEntityMapper;

    public MusicRepositoryGateway(MusicRepository musicRepository, MusicEntityMapper musicEntityMapper) {
        this.musicRepository = musicRepository;
        this.musicEntityMapper = musicEntityMapper;
    }

    @Override
    public Music createMusic(Music musicDomainObj) {
        MusicEntity musicToBePersisted = musicEntityMapper.domainObjToEntity(musicDomainObj);

        return musicEntityMapper.entityToDomainObj(
                this.musicRepository.save(musicToBePersisted)
        );
    }
}
