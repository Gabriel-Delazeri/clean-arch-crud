package com.delazeri.cleanarch.infrastructure.controllers;

import com.delazeri.cleanarch.application.usecases.contracts.*;
import com.delazeri.cleanarch.domain.entity.Music;
import com.delazeri.cleanarch.infrastructure.controllers.requests.MusicRequest;
import com.delazeri.cleanarch.infrastructure.controllers.responses.MusicResponse;
import com.delazeri.cleanarch.infrastructure.controllers.responses.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/musics")
public class MusicController {
    private final CreateMusicUseCase createMusicUseCase;
    private final MusicDTOMapper musicDTOMapper;
    private final FindMusicUseCase<Long> findMusicUseCase;
    private final FindAllMusicsUseCase findAllMusicsUseCase;
    private final UpdateMusicUseCase<Long> updateMusicUseCase;
    private final DeleteMusicUseCase<Long> deleteMusicUseCase;

    MusicController(CreateMusicUseCase createMusicUseCase, MusicDTOMapper musicDTOMapper, FindMusicUseCase<Long> findMusicUseCase, FindAllMusicsUseCase findAllMusicsUseCase, UpdateMusicUseCase<Long> updateMusicUseCase, DeleteMusicUseCase<Long> deleteMusicUseCase) {
        this.createMusicUseCase = createMusicUseCase;
        this.musicDTOMapper = musicDTOMapper;
        this.findMusicUseCase = findMusicUseCase;
        this.findAllMusicsUseCase = findAllMusicsUseCase;
        this.updateMusicUseCase = updateMusicUseCase;
        this.deleteMusicUseCase = deleteMusicUseCase;
    }
    @GetMapping
    public ResponseEntity<Response<List<MusicResponse>>> findAll() {
        List<MusicResponse> response = this.findAllMusicsUseCase.findAllMusics().stream()
                .map(musicDTOMapper::domainObJToRawResponse)
                .toList();

        return ResponseEntity.ok(new Response<>(response, true));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Response<MusicResponse>> findMusicById(@PathVariable Long id) {
        return ResponseEntity.ok(musicDTOMapper.domainObjToResponse(this.findMusicUseCase.findMusic(id), true));
    }

    @PostMapping
    public ResponseEntity<Response<MusicResponse>> saveMusic(@RequestBody MusicRequest createMusicRequest) {
        Music music = this.createMusicUseCase.createMusic(musicDTOMapper.requestToDomainObj(createMusicRequest));

        return ResponseEntity.ok(musicDTOMapper.domainObjToResponse(music, true));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Response<MusicResponse>> updateMusic(
            @PathVariable Long id,
            @RequestBody MusicRequest updateMusicRequest
    ) {
        Music music = this.updateMusicUseCase.updateMusic(id, musicDTOMapper.requestToDomainObj(updateMusicRequest));

        return ResponseEntity.ok(musicDTOMapper.domainObjToResponse(music, true));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteMusic(@PathVariable Long id) {
        this.deleteMusicUseCase.deleteMusic(id);

        return ResponseEntity.noContent().build();
    }
}
