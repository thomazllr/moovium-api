package com.github.thomazllr.moovium.model.session;
import com.github.thomazllr.moovium.entity.Session;
import com.github.thomazllr.moovium.entity.SeatReservation;

import java.time.LocalDateTime;
import java.util.List;

public record SessionResponse(String movie, String theater, LocalDateTime sessionTime, Integer capacity ,List<SeatReservation> reservations) {
    public static SessionResponse toResponse(Session session) {

        return new SessionResponse(
                session.getMovie().getTitle(),
                session.getTheater().getName(),
                session.getSessionTime(),
                session.getTheater().getCapacity(),
                session.getReservations());
    }
}
