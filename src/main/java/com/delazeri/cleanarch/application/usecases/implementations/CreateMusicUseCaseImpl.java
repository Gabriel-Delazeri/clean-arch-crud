package com.delazeri.cleanarch.application.usecases.implementations;

import com.delazeri.cleanarch.application.gateways.MusicGateway;
import com.delazeri.cleanarch.application.usecases.contracts.CreateMusicUseCase;
import com.delazeri.cleanarch.domain.entity.Music;

public class CreateMusicUseCaseImpl implements CreateMusicUseCase {
    private final MusicGateway musicGateway;

    public CreateMusicUseCaseImpl(MusicGateway musicGateway) {
        this.musicGateway = musicGateway;
    }

    @Override
    public Music createMusic(Music music) {
        return musicGateway.createMusic(music);
    }
}
