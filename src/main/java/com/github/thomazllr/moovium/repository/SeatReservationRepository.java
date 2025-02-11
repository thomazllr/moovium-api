package com.github.thomazllr.moovium.repository;

import com.github.thomazllr.moovium.entity.Seat;
import com.github.thomazllr.moovium.entity.SeatReservation;
import com.github.thomazllr.moovium.entity.Session;
import com.github.thomazllr.moovium.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface SeatReservationRepository extends JpaRepository<SeatReservation, UUID> {

    boolean existsBySessionAndSeatAndStatus(Session session, Seat seat, Status status);

    @Query(value = "SELECT COUNT(*) FROM seat_reservation", nativeQuery = true)
    long countAll();

    @Modifying
    @Query(value = "DELETE FROM seat_reservation WHERE status = 'RESERVED' AND reservation_expiration < NOW()", nativeQuery = true)
    void deleteExpiredReservations();
}
