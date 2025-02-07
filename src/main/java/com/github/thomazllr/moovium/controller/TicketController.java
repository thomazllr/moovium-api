package com.github.thomazllr.moovium.controller;

import com.github.thomazllr.moovium.model.Ticket;
import com.github.thomazllr.moovium.model.dto.ticket.TicketRequest;
import com.github.thomazllr.moovium.model.dto.ticket.TicketResponse;
import com.github.thomazllr.moovium.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TicketResponse> save(@RequestBody TicketRequest request) {
        var ticket = service.create(request);
        URI location = URI.create("/ticket" + ticket.getId());
        return ResponseEntity.created(location).body(TicketResponse.toResponse(ticket));
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
