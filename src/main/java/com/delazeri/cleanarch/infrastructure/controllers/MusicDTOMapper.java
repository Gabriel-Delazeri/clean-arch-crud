package com.delazeri.cleanarch.infrastructure.controllers;

import com.delazeri.cleanarch.domain.entity.Music;
import com.delazeri.cleanarch.infrastructure.controllers.requests.CreateMusicRequest;
import com.delazeri.cleanarch.infrastructure.controllers.responses.CreateMusicResponse;
import com.delazeri.cleanarch.infrastructure.controllers.responses.Response;

public class MusicDTOMapper {

    public Music requestToDomainObj(CreateMusicRequest request) {
        return new Music(request.name(), request.slug(), request.imageUrl(), request.artistName(), request.durationMs());
    }

    public Response<CreateMusicResponse> domainObjToResponse(Music music, boolean success) {
        return new Response<>(
                new CreateMusicResponse(
                        music.name(),
                        music.slug(),
                        music.imageUrl(),
                        music.artistName(),
                        music.durationMs()
                ),
                success
        );
    }
}
