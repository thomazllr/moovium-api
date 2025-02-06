package com.github.thomazllr.moovium.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    private LocalDate sessionTime;

    private Integer seatsAvailable;

    private Integer totalSeats;

    private String theaterName;

    @CreatedDate
    private LocalDate createdAt;

    @LastModifiedDate
    private LocalDate updatedAt;

    public Session() {
    }

    public Session(UUID id, Movie movie, LocalDate sessionTime, Integer seatsAvailable, Integer totalSeats, String theaterName, LocalDate createdAt, LocalDate updatedAt) {
        this.id = id;
        this.movie = movie;
        this.sessionTime = sessionTime;
        this.seatsAvailable = seatsAvailable;
        this.totalSeats = totalSeats;
        this.theaterName = theaterName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDate getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(LocalDate sessionTime) {
        this.sessionTime = sessionTime;
    }

    public Integer getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(Integer seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}
