package com.delazeri.cleanarch.infrastructure.config;

import com.delazeri.cleanarch.application.gateways.MusicGateway;
import com.delazeri.cleanarch.application.usecases.CreateMusicUseCase;
import com.delazeri.cleanarch.application.usecases.CreateMusicUseCaseImpl;
import com.delazeri.cleanarch.infrastructure.controllers.MusicDTOMapper;
import com.delazeri.cleanarch.infrastructure.gateways.jpa.MusicEntityMapper;
import com.delazeri.cleanarch.infrastructure.gateways.jpa.MusicRepositoryGateway;
import com.delazeri.cleanarch.infrastructure.persistence.jpa.MusicRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MusicConfig {
    @Bean
    CreateMusicUseCase createMusicUseCase(MusicGateway musicGateway) {
        return new CreateMusicUseCaseImpl(musicGateway);
    }

    @Bean
    MusicGateway musicGateway(MusicRepository musicRepository, MusicEntityMapper musicEntityMapper) {
        return new MusicRepositoryGateway(musicRepository, musicEntityMapper);
    }

    @Bean
    MusicEntityMapper musicEntityMapper() {
        return new MusicEntityMapper();
    }

    @Bean
    MusicDTOMapper musicDTOMapper() {
        return new MusicDTOMapper();
    }
}