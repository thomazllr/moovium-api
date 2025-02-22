package com.github.thomazllr.moovium.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

}
