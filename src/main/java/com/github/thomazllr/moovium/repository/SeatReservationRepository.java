package com.github.thomazllr.moovium.repository;

import com.github.thomazllr.moovium.entity.Seat;
import com.github.thomazllr.moovium.entity.SeatReservation;
import com.github.thomazllr.moovium.entity.Session;
import com.github.thomazllr.moovium.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SeatReservationRepository extends JpaRepository<SeatReservation, UUID> {

    boolean existsBySessionAndSeatAndStatus(Session session, Seat seat, Status status);

}
