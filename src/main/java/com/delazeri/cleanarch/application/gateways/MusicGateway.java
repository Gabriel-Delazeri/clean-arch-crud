package com.delazeri.cleanarch.application.gateways;

import com.delazeri.cleanarch.domain.entity.Music;

import java.util.List;

public interface MusicGateway<T> {
    Music createMusic(Music music);
    Music findMusic(T t);
    List<Music> findAllMusics();
    Music updateMusic(T t, Music music);
}
