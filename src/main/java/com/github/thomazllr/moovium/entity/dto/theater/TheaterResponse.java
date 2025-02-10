package com.github.thomazllr.moovium.entity.dto.theater;

import com.github.thomazllr.moovium.entity.Theater;

import java.util.UUID;

public record TheaterResponse(UUID id, String name) {

    public static TheaterResponse toResponse(Theater theater) {
        return new TheaterResponse(theater.getId(), theater.getName());
    }
}
