package com.delazeri.cleanarch.application.usecases.contracts;

import com.delazeri.cleanarch.domain.entity.Music;

import java.util.List;

public interface FindAllMusicsUseCase {
    List<Music> findAllMusics();
}
