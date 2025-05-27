package com.github.thomazllr.moovium.web.dto.seat.reservation;

import com.github.thomazllr.moovium.entity.SeatReservation;
import com.github.thomazllr.moovium.entity.Status;

import java.time.LocalDateTime;

public record SeatReservationResponse(String movie,
                                      LocalDateTime sessionTime,
                                      Status status,
                                      String theater,
                                      String seatNumber,
                                      String row,
                                      LocalDateTime reservationExpiration) {
    public static SeatReservationResponse toResponse(SeatReservation reservation) {
        return new SeatReservationResponse(
                reservation.getSession().getMovie().getTitle(),
                reservation.getSession().getSessionTime(),
                reservation.getStatus(),
                reservation.getSession().getTheater().getName(),
                reservation.getSeat().getSeatNumber(),
                reservation.getSeat().getRow(),
                reservation.getReservationExpiration());
    }
}
