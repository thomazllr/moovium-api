package com.github.thomazllr.moovium.repository;

import com.github.thomazllr.moovium.model.theater.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TheaterRepository extends JpaRepository<Theater, UUID> {
}
