package com.github.thomazllr.moovium.controller;

import com.github.thomazllr.moovium.entity.Ticket;
import com.github.thomazllr.moovium.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<Ticket>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
