package com.github.thomazllr.moovium.web.dto.theater;

import com.github.thomazllr.moovium.entity.RoomType;

public record TheaterRequest(String name, RoomType roomType) {
}
