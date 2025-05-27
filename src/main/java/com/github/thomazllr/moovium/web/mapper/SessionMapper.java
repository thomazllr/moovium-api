package com.github.thomazllr.moovium.web.mapper;

import com.github.thomazllr.moovium.entity.Movie;
import com.github.thomazllr.moovium.entity.Session;
import com.github.thomazllr.moovium.entity.Theater;
import com.github.thomazllr.moovium.web.dto.seat.reservation.SeatReservationResponseForMovie;
import com.github.thomazllr.moovium.web.dto.session.SessionRequest;
import com.github.thomazllr.moovium.web.dto.session.SessionResponse;

import java.util.ArrayList;
import java.util.UUID;

public class SessionMapper {

    public static Session fromRequest(SessionRequest request) {

        var movie = new Movie();
        movie.setId(UUID.fromString(request.movie()));
        var theater = new Theater();
        theater.setId(UUID.fromString(request.theater()));
        Session session = new Session();
        session.setMovie(movie);
        session.setSessionTime(request.sessionTime());
        session.setTheater(theater);
        session.setReservations(new ArrayList<>());
        return session;
    }

    public static SessionResponse toResponse(Session session) {
        return new SessionResponse(
                session.getId(),
                session.getMovie().getTitle(),
                session.getTheater().getName(),
                session.getSessionTime(),
                session.getTheater().getCapacity(),
                session.getReservations().stream()
                        .map(SeatReservationResponseForMovie::toSeatReservationResponseForMovie)
                        .toList()
        );
    }


}
