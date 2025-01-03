package com.example.demo.services;

import com.example.demo.entities.ticket.Ticket;
import com.example.demo.repositories.TicketBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class TicketBookingService {

    @Autowired
    private TicketBookingRepository ticketBookingDao;

    public Ticket createTicket(Ticket ticket) {
        return ticketBookingDao.save(ticket);
    }

    public Ticket getTicketById(Long ticketId) {
        Optional<Ticket> ticket= ticketBookingDao.findById(ticketId);

        return ticket.orElse(null);
    }

    public Iterable<Ticket> getAllBookedTickets() {
        return ticketBookingDao.findAll();
    }

    public void deleteTicket(Long ticketId) {
        ticketBookingDao.deleteById(ticketId);
    }

    public Ticket updateTicket(Long ticketId, String newEmail) {
        Ticket ticket= ticketBookingDao.findById(ticketId).orElse(null);
        if(ticket==null) {
            return null;
        }

        ticket.setEmail(newEmail);
        ticketBookingDao.save(ticket);
        return ticket;
    }
}
