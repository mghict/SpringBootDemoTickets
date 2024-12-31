package com.example.controllers;

import com.example.entities.Ticket;
import com.example.services.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/tickets")
public class TicketBookingController {

    @Autowired
    private TicketBookingService ticketBookingService;

    @PostMapping(value = "/create")
    public Ticket createTicket(@RequestBody Ticket ticket)
    {

        return ticketBookingService.createTicket(ticket);
    }

    @GetMapping(value = "/ticket/{ticketId}")
    public Ticket getTicketById(@PathVariable("ticketId") Long ticketId){
        return ticketBookingService.getTicketById(ticketId);
    }

    @GetMapping(value = "/ticket/alltickets")
    public Iterable<Ticket> getAllBookedTickets(){
        return ticketBookingService.getAllBookedTickets();
    }

    @DeleteMapping(value = "/ticket/{ticketId}")
    public void deleteTicket(@PathVariable("ticketId") Long ticketId){
        ticketBookingService.deleteTicket(ticketId);
    }

    @PutMapping(value = "/ticket/{ticketId}/{newEmail:.+}")
    public Ticket updateTicket(@PathVariable("ticketId") Long ticketId,
                               @PathVariable("newEmail") String newEmail){
        return ticketBookingService.updateTicket(ticketId,newEmail);
    }

}
