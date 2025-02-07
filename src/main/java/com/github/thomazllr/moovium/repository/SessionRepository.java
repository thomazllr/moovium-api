package com.github.thomazllr.moovium.repository;

import com.github.thomazllr.moovium.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SessionRepository extends JpaRepository<Session, UUID> {
}
