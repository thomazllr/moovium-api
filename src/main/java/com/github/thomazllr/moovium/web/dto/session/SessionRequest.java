package com.github.thomazllr.moovium.web.dto.session;

import java.time.LocalDateTime;

public record SessionRequest(
        String movie,
        LocalDateTime sessionTime,
        String theater) {
}
