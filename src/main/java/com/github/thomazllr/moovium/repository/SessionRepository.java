package com.github.thomazllr.moovium.repository;

import com.github.thomazllr.moovium.model.Movie;
import com.github.thomazllr.moovium.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public interface SessionRepository extends JpaRepository<Session, UUID> {

    long countByMovie(Movie movie);

    boolean existsBySessionTimeAndTheaterName(LocalDateTime sessionTime, String theaterName);

}
