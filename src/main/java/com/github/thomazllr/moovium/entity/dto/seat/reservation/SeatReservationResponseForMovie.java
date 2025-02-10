package com.github.thomazllr.moovium.entity.dto.seat.reservation;

import com.github.thomazllr.moovium.entity.SeatReservation;

public record SeatReservationResponseForMovie(String seatNumber,
                                              String rowNumber) {

    public static SeatReservationResponseForMovie toSeatReservationResponseForMovie(SeatReservation seatReservation) {
        return new SeatReservationResponseForMovie(seatReservation.getSeat().getSeatNumber(), seatReservation.getSeat().getRowNumber());
    }
}
