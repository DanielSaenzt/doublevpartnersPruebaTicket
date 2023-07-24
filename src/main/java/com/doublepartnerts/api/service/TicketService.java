package com.doublepartnerts.api.service;

// Importaciones necesarias
import com.doublepartnerts.api.entity.Ticket;
import com.doublepartnerts.api.repository.ITicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

// Anotación que marca esta clase como un servicio de Spring
@Service
public class TicketService {
    private final ITicketRepository ticketRepository;

    // Inyección de dependencia del repositorio de tickets mediante autowiring
    @Autowired
    public TicketService(ITicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    // Método para obtener todos los tickets paginados
    public Page<Ticket> getAllTicketsPage(Pageable pageable) {
        return ticketRepository.findAll(pageable);
    }

    // Método para filtrar tickets por su identificador (id) y obtenerlos paginados
    public Page<Ticket> filterTicketsById(Long id, Pageable pageable) {
        return ticketRepository.findById(id, pageable);
    }

    // Método para obtener un ticket por su identificador (id)
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    // Método para crear un nuevo ticket
    public Ticket createTicket(Ticket ticket) {
        ticket.setCreatedAt(new Date());
        ticket.setUpdateDate(new Date());
        return ticketRepository.save(ticket);
    }

    // Método para actualizar un ticket existente por su identificador (id)
    public Ticket updateTicket(Long id, Ticket updatedTicket) {
        Ticket ticket = ticketRepository.findById(id).orElse(null);
        if (ticket != null) {
            ticket.setUser(updatedTicket.getUser());
            ticket.setStatus(updatedTicket.isStatus());
            ticket.setUpdateDate(new Date());
            return ticketRepository.save(ticket);
        }
        return null;
    }

    // Método para eliminar un ticket por su identificador (id)
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}


