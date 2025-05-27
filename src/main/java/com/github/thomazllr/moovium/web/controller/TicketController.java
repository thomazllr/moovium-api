package com.github.thomazllr.moovium.web.controller;

import com.github.thomazllr.moovium.entity.Ticket;
import com.github.thomazllr.moovium.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService service;

    @GetMapping("/tickets/{id}/qr-image")
    public ResponseEntity<byte[]> getQRCodeImage(@PathVariable String id) {
        Ticket ticket = service.findById(id);

        byte[] imageBytes = Base64.getDecoder().decode(ticket.getQrCode());

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(imageBytes);
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
