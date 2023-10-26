package com.delazeri.cleanarch.application.gateways;

import com.delazeri.cleanarch.domain.entity.Music;

public interface MusicGateway<T> {
    Music createMusic(Music music);
    Music findMusic(T t);
}
