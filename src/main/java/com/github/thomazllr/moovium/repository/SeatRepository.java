package com.github.thomazllr.moovium.repository;

import com.github.thomazllr.moovium.entity.Seat;
import com.github.thomazllr.moovium.entity.Theater;
import com.github.thomazllr.moovium.repository.projections.SeatStatusProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface SeatRepository extends JpaRepository<Seat, UUID> {

    boolean existsByTheaterAndSeatNumberAndRow(Theater theater, String seatNumber, String row);

    List<Seat> findByTheater(Theater theater);

    @Query("""
        SELECT s.seatNumber as seatNumber,
               s.row as row,
               COALESCE(sr.status, 'AVAILABLE') as status
        FROM Seat s\s
        LEFT JOIN SeatReservation sr ON s.id = sr.seat.id AND sr.session.id = :sessionId
        WHERE s.theater.id IN (
            SELECT sess.theater.id FROM Session sess WHERE sess.id = :sessionId
        )
        ORDER BY s.row, s.seatNumber
       \s""")
    List<SeatStatusProjection> findSeatStatusesBySessionId(@Param("sessionId") UUID sessionId);


}
