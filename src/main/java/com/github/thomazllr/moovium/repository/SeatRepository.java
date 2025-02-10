package com.github.thomazllr.moovium.repository;

import com.github.thomazllr.moovium.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SeatRepository extends JpaRepository<Seat, UUID> {
}
