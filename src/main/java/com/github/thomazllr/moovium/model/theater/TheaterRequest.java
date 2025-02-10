package com.github.thomazllr.moovium.model.theater;

import com.github.thomazllr.moovium.entity.RoomType;
import com.github.thomazllr.moovium.entity.Theater;

public record TheaterRequest(String name, RoomType roomType) {

    public Theater toTheater() {
        Theater theater = new Theater();
        theater.setName(name);
        theater.setRoomType(roomType);
        return theater;
    }
}
