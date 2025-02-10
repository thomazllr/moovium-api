package com.github.thomazllr.moovium.repository;

import com.github.thomazllr.moovium.entity.Seat;
import com.github.thomazllr.moovium.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SeatRepository extends JpaRepository<Seat, UUID> {

    boolean existsByTheaterAndSeatNumberAndRow(Theater theater, String seatNumber, String row);
}
