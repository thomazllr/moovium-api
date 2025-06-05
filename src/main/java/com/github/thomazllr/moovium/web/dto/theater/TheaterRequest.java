package com.github.thomazllr.moovium.web.dto.theater;

import com.github.thomazllr.moovium.entity.RoomType;
import com.github.thomazllr.moovium.entity.Theater;

public record TheaterRequest(String name, RoomType roomType) {


    public static Theater toEntity(TheaterRequest request) {

        return Theater.builder()
                .name(request.name())
                .roomType(request.roomType())
                .capacity(100)
                .build();
    }
}
