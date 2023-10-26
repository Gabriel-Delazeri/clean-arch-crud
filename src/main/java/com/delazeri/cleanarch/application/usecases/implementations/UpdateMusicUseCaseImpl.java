package com.delazeri.cleanarch.application.usecases.implementations;

import com.delazeri.cleanarch.application.gateways.MusicGateway;
import com.delazeri.cleanarch.application.usecases.contracts.UpdateMusicUseCase;
import com.delazeri.cleanarch.domain.entity.Music;

public class UpdateMusicUseCaseImpl<T> implements UpdateMusicUseCase<T> {
    private final MusicGateway<T> musicGateway;

    public UpdateMusicUseCaseImpl(MusicGateway<T> musicGateway) {
        this.musicGateway = musicGateway;
    }

    @Override
    public Music updateMusic(T t, Music music) {
        return musicGateway.updateMusic(t, music);
    }
}
