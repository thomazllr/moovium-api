package com.github.thomazllr.moovium.repository.projections;

import com.github.thomazllr.moovium.entity.Status;

public interface SeatStatusProjection {
    String getSeatNumber();
    String getRow();
    Status getStatus();
}
