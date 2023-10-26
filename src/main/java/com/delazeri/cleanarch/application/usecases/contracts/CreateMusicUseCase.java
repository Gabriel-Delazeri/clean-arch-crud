package com.delazeri.cleanarch.application.usecases.contracts;

import com.delazeri.cleanarch.domain.entity.Music;

public interface CreateMusicUseCase {
    Music createMusic(Music music);
}
