package com.github.thomazllr.moovium.entity.dto.session;

import com.github.thomazllr.moovium.entity.dto.seat.reservation.SeatReservationResponseForMovie;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record SessionResponse(UUID id, String movie, String theater, LocalDateTime sessionTime, Integer capacity , List<SeatReservationResponseForMovie> reservations) {
}
