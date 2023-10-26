package com.delazeri.cleanarch.application.usecases.implementations;

import com.delazeri.cleanarch.application.gateways.MusicGateway;
import com.delazeri.cleanarch.application.usecases.contracts.DeleteMusicUseCase;

public class DeleteMusicUseCaseImpl<T> implements DeleteMusicUseCase<T> {
    private final MusicGateway<T> musicGateway;

    public DeleteMusicUseCaseImpl(MusicGateway<T> musicGateway) {
        this.musicGateway = musicGateway;
    }

    @Override
    public void deleteMusic(T t) {
        musicGateway.deleteMusic(t);
    }
}
