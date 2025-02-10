package com.github.thomazllr.moovium.entity.dto.session;
import com.github.thomazllr.moovium.entity.Session;
import com.github.thomazllr.moovium.entity.SeatReservation;
import com.github.thomazllr.moovium.entity.dto.seat.reservation.SeatReservationResponseForMovie;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record SessionResponse(UUID id, String movie, String theater, LocalDateTime sessionTime, Integer capacity , List<SeatReservationResponseForMovie> reservations) {
    public static SessionResponse toResponse(Session session) {

        return new SessionResponse(
                session.getId(),
                session.getMovie().getTitle(),
                session.getTheater().getName(),
                session.getSessionTime(),
                session.getTheater().getCapacity(),
                session.getReservations().stream().map(SeatReservationResponseForMovie::toSeatReservationResponseForMovie).toList());
    }
}
