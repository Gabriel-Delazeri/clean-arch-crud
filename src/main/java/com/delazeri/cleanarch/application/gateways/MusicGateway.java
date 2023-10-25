package com.delazeri.cleanarch.application.gateways;

import com.delazeri.cleanarch.domain.entity.Music;

public interface MusicGateway {
    Music createMusic(Music music);
}
