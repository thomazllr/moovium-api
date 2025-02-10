package com.github.thomazllr.moovium.entity.dto.seat;

import com.github.thomazllr.moovium.entity.Seat;
import com.github.thomazllr.moovium.entity.Theater;

public record SeatRequest(String theater, String seatNumber, String rowNumber) {

    public Seat toSeat(Theater theater) {
        Seat seat = new Seat();
        seat.setTheater(theater);
        seat.setSeatNumber(seatNumber);
        seat.setRowNumber(rowNumber);
        return seat;
    }
}
