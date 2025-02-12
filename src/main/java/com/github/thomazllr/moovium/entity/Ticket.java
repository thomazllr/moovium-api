package com.github.thomazllr.moovium.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(precision = 18, scale = 2)
    private BigDecimal price;

    private String qrCode;

    public Ticket() {
    }

    public Ticket(UUID id, SeatReservation seatReservation, BigDecimal price, String qrCode) {
        this.id = id;
        this.seatReservation = seatReservation;
        this.price = price;
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


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    private Ticket(Builder builder) {
        this.id = builder.id;
        this.seatReservation = builder.seatReservation;
        this.price = builder.price;
        this.qrCode = builder.qrCode;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private UUID id;
        private SeatReservation seatReservation;
        private BigDecimal price;
        private String qrCode;

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder seatReservation(SeatReservation seatReservation) {
            this.seatReservation = seatReservation;
            return this;
        }


        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder qrCode(String qrCode) {
            this.qrCode = qrCode;
            return this;
        }

        public Ticket build() {
            return new Ticket(this);
        }
    }
}
