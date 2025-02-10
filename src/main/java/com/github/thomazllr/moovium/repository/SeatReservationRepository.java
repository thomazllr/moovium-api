package com.github.thomazllr.moovium.repository;

import com.github.thomazllr.moovium.entity.SeatReservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SeatReservationRepository extends JpaRepository<SeatReservation, UUID> {
}
