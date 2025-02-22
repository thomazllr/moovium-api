package com.github.thomazllr.moovium.entity.dto.session;

import java.time.LocalDateTime;

public record SessionRequest(
        String movie,
        LocalDateTime sessionTime,
        String theater) {
}
