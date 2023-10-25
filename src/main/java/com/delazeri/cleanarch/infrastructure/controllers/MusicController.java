package com.delazeri.cleanarch.infrastructure.controllers;

import com.delazeri.cleanarch.application.usecases.CreateMusicUseCase;
import com.delazeri.cleanarch.domain.entity.Music;
import com.delazeri.cleanarch.infrastructure.controllers.requests.CreateMusicRequest;
import com.delazeri.cleanarch.infrastructure.controllers.responses.CreateMusicResponse;
import com.delazeri.cleanarch.infrastructure.controllers.responses.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/musics")
public class MusicController {
    private final CreateMusicUseCase createMusicUseCase;
    private final MusicDTOMapper musicDTOMapper;

    MusicController(CreateMusicUseCase createMusicUseCase, MusicDTOMapper musicDTOMapper) {
        this.createMusicUseCase = createMusicUseCase;
        this.musicDTOMapper = musicDTOMapper;
    }

    @PostMapping
    public ResponseEntity<Response<CreateMusicResponse>> saveMusic(@RequestBody CreateMusicRequest createMusicRequest) {
        Music music = this.createMusicUseCase.createMusic(musicDTOMapper.requestToDomainObj(createMusicRequest));

        return ResponseEntity.ok(musicDTOMapper.domainObjToResponse(music, true));
    }
}
