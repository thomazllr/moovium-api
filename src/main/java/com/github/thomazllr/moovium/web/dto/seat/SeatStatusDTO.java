package com.github.thomazllr.moovium.web.dto.seat;

import com.github.thomazllr.moovium.entity.Seat;
import com.github.thomazllr.moovium.entity.SeatReservation;
import com.github.thomazllr.moovium.entity.Status;

public record SeatStatusDTO(String seatNumber, String row, Status status) {


    public static SeatStatusDTO toSeatStatusDTO(Seat seat, SeatReservation reservation) {
        return new SeatStatusDTO(seat.getSeatNumber(), seat.getRow(), reservation.getStatus());
    }

}
