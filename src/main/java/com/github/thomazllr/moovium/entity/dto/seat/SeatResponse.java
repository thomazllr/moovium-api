package com.github.thomazllr.moovium.entity.dto.seat;

import com.github.thomazllr.moovium.entity.Seat;

import java.util.UUID;

public record SeatResponse(UUID id, String theater, String seatNumber, String rowNumber) {

    public static SeatResponse toResponse(Seat seat) {
        return new SeatResponse(seat.getId(),seat.getTheater().getName(), seat.getSeatNumber(), seat.getRowNumber());
    }
}
