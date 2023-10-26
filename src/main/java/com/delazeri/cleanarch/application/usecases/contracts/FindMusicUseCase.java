package com.delazeri.cleanarch.application.usecases.contracts;

import com.delazeri.cleanarch.domain.entity.Music;

public interface FindMusicUseCase<T> {
    Music findMusic(T t);
}
