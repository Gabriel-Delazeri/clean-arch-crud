package com.delazeri.cleanarch.application.usecases.contracts;

import com.delazeri.cleanarch.domain.entity.Music;

public interface UpdateMusicUseCase<T> {
    Music updateMusic(T t, Music music);
}
