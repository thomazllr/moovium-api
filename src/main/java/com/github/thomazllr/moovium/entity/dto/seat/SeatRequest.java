package com.github.thomazllr.moovium.entity.dto.seat;

import com.github.thomazllr.moovium.entity.Seat;
import com.github.thomazllr.moovium.entity.Theater;
import jakarta.validation.constraints.Pattern;

public record SeatRequest(String theater,
                          @Pattern(regexp = "^(?:[1-9]|10)$", message = "Seat number must be between 1 and 10")
                          String seatNumber,
                          @Pattern(regexp = "^[A-J]$", message = "Row must be between A and J")
                          String row) {

    public Seat toSeat(Theater theater) {
        Seat seat = new Seat();
        seat.setTheater(theater);
        seat.setSeatNumber(seatNumber);
        seat.setRow(row);
        return seat;
    }
}
