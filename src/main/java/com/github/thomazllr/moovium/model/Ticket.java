package com.github.thomazllr.moovium.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

        @OneToOne
        private Session session;

        private String seatNumber;

        @Column(precision = 18, scale = 2)
        private BigDecimal price;

        private boolean isSold;

}
