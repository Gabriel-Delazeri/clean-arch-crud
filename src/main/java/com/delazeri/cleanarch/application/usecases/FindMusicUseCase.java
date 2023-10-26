package com.delazeri.cleanarch.application.usecases;

import com.delazeri.cleanarch.domain.entity.Music;

public interface FindMusicUseCase<T> {
    Music findMusic(T t);
}
