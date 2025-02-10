package com.github.thomazllr.moovium.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Theater theater;

    private String seatNumber;

    private String row;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Seat() {
    }

    public Seat(UUID id, Theater theater, String seatNumber, String row, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.theater = theater;
        this.seatNumber = seatNumber;
        this.row = row;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Seat(Theater theater, String seatNumber, String row) {
        this.theater = theater;
        this.seatNumber = seatNumber;
        this.row = row;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
