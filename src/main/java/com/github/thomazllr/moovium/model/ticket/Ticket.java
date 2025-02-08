package com.github.thomazllr.moovium.model.ticket;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.thomazllr.moovium.model.seat.reservation.SeatReservation;
import com.github.thomazllr.moovium.model.session.Session;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "reservation_id", unique = true)
    @JsonIgnore
    private SeatReservation seatReservation;

    private String seatNumber;

    @Column(precision = 18, scale = 2)
    private BigDecimal price;

    private boolean isSold;

    private String qrCode;

    public Ticket() {
    }

    public Ticket(UUID id, SeatReservation seatReservation, String seatNumber, BigDecimal price, boolean isSold, String qrCode) {
        this.id = id;
        this.seatReservation = seatReservation;
        this.seatNumber = seatNumber;
        this.price = price;
        this.isSold = isSold;
        this.qrCode = qrCode;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public SeatReservation getSeatReservation() {
        return seatReservation;
    }

    public void setSeatReservation(SeatReservation seatReservation) {
        this.seatReservation = seatReservation;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
}
