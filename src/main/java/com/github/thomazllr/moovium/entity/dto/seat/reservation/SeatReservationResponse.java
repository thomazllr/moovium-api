package com.github.thomazllr.moovium.entity.dto.seat.reservation;

import com.github.thomazllr.moovium.entity.SeatReservation;

import java.time.LocalDateTime;

public record SeatReservationResponse(String movie,
                                      LocalDateTime sessionTime,
                                      String theater,
                                      String seatNumber,
                                      String rowNumber) {
    public static SeatReservationResponse toResponse(SeatReservation reservation) {
        return new SeatReservationResponse(
                reservation.getSession().getMovie().getTitle(),
                reservation.getSession().getSessionTime(),
                reservation.getSession().getTheater().getName(),
                reservation.getSeat().getSeatNumber(),
                reservation.getSeat().getRowNumber());
    }
}
