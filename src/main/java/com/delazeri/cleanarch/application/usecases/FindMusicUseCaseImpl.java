package com.delazeri.cleanarch.application.usecases;

import com.delazeri.cleanarch.application.gateways.MusicGateway;
import com.delazeri.cleanarch.domain.entity.Music;

public class FindMusicUseCaseImpl<T> implements FindMusicUseCase<T>{
    private final MusicGateway<T> musicGateway;

    public FindMusicUseCaseImpl(MusicGateway<T> musicGateway) {
        this.musicGateway = musicGateway;
    }

    @Override
    public Music findMusic(T t) {
        return musicGateway.findMusic(t);
    }
}
