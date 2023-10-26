package com.delazeri.cleanarch.application.usecases;

import com.delazeri.cleanarch.application.gateways.MusicGateway;
import com.delazeri.cleanarch.domain.entity.Music;

import java.util.List;

public class FindAllMusicsUseCaseImpl implements FindAllMusicsUseCase {
    private final MusicGateway musicGateway;

    public FindAllMusicsUseCaseImpl(MusicGateway musicGateway) {
        this.musicGateway = musicGateway;
    }

    @Override
    public List<Music> findAllMusics() {
        return musicGateway.findAllMusics();
    }
}
