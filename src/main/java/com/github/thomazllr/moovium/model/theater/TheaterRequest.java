package com.github.thomazllr.moovium.model.theater;

public record TheaterRequest(String name, RoomType roomType) {

    public Theater toTheater() {
        Theater theater = new Theater();
        theater.setName(name);
        theater.setRoomType(roomType);
        return theater;
    }
}
