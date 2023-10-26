package com.delazeri.cleanarch.infrastructure.controllers;

import com.delazeri.cleanarch.application.usecases.CreateMusicUseCase;
import com.delazeri.cleanarch.application.usecases.FindMusicUseCase;
import com.delazeri.cleanarch.domain.entity.Music;
import com.delazeri.cleanarch.infrastructure.controllers.requests.CreateMusicRequest;
import com.delazeri.cleanarch.infrastructure.controllers.responses.MusicResponse;
import com.delazeri.cleanarch.infrastructure.controllers.responses.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/musics")
public class MusicController {
    private final CreateMusicUseCase createMusicUseCase;
    private final MusicDTOMapper musicDTOMapper;
    private final FindMusicUseCase<Long> findMusicUseCase;

    MusicController(CreateMusicUseCase createMusicUseCase, MusicDTOMapper musicDTOMapper, FindMusicUseCase<Long> findMusicUseCase) {
        this.createMusicUseCase = createMusicUseCase;
        this.musicDTOMapper = musicDTOMapper;
        this.findMusicUseCase = findMusicUseCase;
    }

    @PostMapping
    public ResponseEntity<Response<MusicResponse>> saveMusic(@RequestBody CreateMusicRequest createMusicRequest) {
        Music music = this.createMusicUseCase.createMusic(musicDTOMapper.requestToDomainObj(createMusicRequest));

        return ResponseEntity.ok(musicDTOMapper.domainObjToResponse(music, true));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Response<MusicResponse>> findMusicById(@PathVariable Long id) {
        return ResponseEntity.ok(musicDTOMapper.domainObjToResponse(this.findMusicUseCase.findMusic(id), true));
    }
}
