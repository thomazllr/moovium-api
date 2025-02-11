package com.github.thomazllr.moovium.entity.dto.seat;

import com.github.thomazllr.moovium.entity.Status;

public record SeatStatusDTO(String seatNumber, String row, Status status) {
}
