package com.github.thomazllr.moovium.web.dto.seat.reservation;

import com.github.thomazllr.moovium.entity.Seat;
import com.github.thomazllr.moovium.entity.SeatReservation;
import com.github.thomazllr.moovium.entity.Session;

public record SeatReservationRequest(String session, String seat) {

    public SeatReservation toSeatReservation(Session session, Seat seat) {
        SeatReservation reservation = new SeatReservation();
        reservation.setSeat(seat);
        reservation.setSession(session);
        return reservation;
    }
}
