package com.delazeri.cleanarch.infrastructure.gateways.jpa;

import com.delazeri.cleanarch.application.gateways.MusicGateway;
import com.delazeri.cleanarch.domain.entity.Music;
import com.delazeri.cleanarch.infrastructure.persistence.jpa.MusicEntity;
import com.delazeri.cleanarch.infrastructure.persistence.jpa.MusicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MusicRepositoryGateway implements MusicGateway<Long> {
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

    @Override
    public Music findMusic(Long id) {
        return musicEntityMapper.entityToDomainObj(musicRepository.findById(id).orElseThrow());
    }

    @Override
    public List<Music> findAllMusics() {
        return musicRepository.findAll().stream()
                .map(musicEntityMapper::entityToDomainObj)
                .collect(Collectors.toList());
    }

    @Override
    public Music updateMusic(Long id, Music music) {
        findMusic(id);

        MusicEntity musicToBePersisted = musicEntityMapper.domainObjToEntity(music);
        musicToBePersisted.setId(id);

        return musicEntityMapper.entityToDomainObj(musicRepository.save(musicToBePersisted));
    }

    @Override
    public void deleteMusic(Long id) {
        MusicEntity musicToDeleted = musicEntityMapper.domainObjToEntity(findMusic(id));

        musicToDeleted.setId(id);

        musicRepository.delete(musicToDeleted);
    }
}
