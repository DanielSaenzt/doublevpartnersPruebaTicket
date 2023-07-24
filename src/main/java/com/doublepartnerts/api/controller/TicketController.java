package com.doublepartnerts.api.controller;

// Importaciones necesarias
import com.doublepartnerts.api.entity.Ticket;
import com.doublepartnerts.api.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

// Anotación que marca esta clase como un controlador de Spring para manejar peticiones HTTP
@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    private final TicketService ticketService;

    // Inyección de dependencia del servicio de tickets mediante autowiring
    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // Método para obtener todos los tickets paginados
    @GetMapping
    public ResponseEntity<Page<Ticket>> getAllTickets(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Ticket> ticketsPage = ticketService.getAllTicketsPage(pageable);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.put("Total-Count", Collections.singletonList(String.valueOf(ticketsPage.getTotalElements())));
        return new ResponseEntity<>(ticketsPage, responseHeaders, HttpStatus.OK);
    }

    // Método para filtrar tickets por su identificador (id) y obtenerlos paginados
    @GetMapping("/filterById")
    public ResponseEntity<Page<Ticket>> filterTicketsById(@RequestParam(required = false) Long id,
                                                          @RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "10") int size) {
        if (id != null) {
            // Si se proporciona un ID, filtramos por ese ID específico
            Ticket ticket = ticketService.getTicketById(id);
            if (ticket == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(new PageImpl<>(Collections.singletonList(ticket)), HttpStatus.OK);
        } else {
            // Si no se proporciona un ID, recuperamos todos los tickets
            Pageable pageable = PageRequest.of(page, size);
            Page<Ticket> ticketsPage = ticketService.getAllTicketsPage(pageable);

            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.put("Total-Count", Collections.singletonList(String.valueOf(ticketsPage.getTotalElements())));
            return new ResponseEntity<>(ticketsPage, responseHeaders, HttpStatus.OK);
        }
    }

    // Método para obtener un ticket por su identificador (id)
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Ticket ticket = ticketService.getTicketById(id);
        return ticket != null ? ResponseEntity.ok(ticket) : ResponseEntity.notFound().build();
    }

    // Método para crear un nuevo ticket
    @PostMapping("/")
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    // Método para actualizar un ticket existente por su identificador (id)
    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Long id, @RequestBody Ticket updatedTicket) {
        Ticket ticket = ticketService.updateTicket(id, updatedTicket);
        return ticket != null ? ResponseEntity.ok(ticket) : ResponseEntity.notFound().build();
    }

    // Método para eliminar un ticket por su identificador (id)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }
}


