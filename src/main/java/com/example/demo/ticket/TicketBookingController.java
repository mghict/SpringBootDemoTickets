package com.example.demo.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/tickets")
public class TicketBookingController {

    @Autowired
    private TicketBookingService ticketBookingService;

    @PostMapping(path = "/create")
    public Ticket createTicket(@RequestBody Ticket ticket)
    {

        return ticketBookingService.createTicket(ticket);
    }

    @GetMapping(path = "/ticket/{ticketId}")
    public Ticket getTicketById(@PathVariable("ticketId") Long ticketId){
        return ticketBookingService.getTicketById(ticketId);
    }

    @GetMapping(path = "/ticket/alltickets")
    public Iterable<Ticket> getAllBookedTickets(){
        return ticketBookingService.getAllBookedTickets();
    }

    @DeleteMapping(path = "/ticket/{ticketId}")
    public void deleteTicket(@PathVariable("ticketId") Long ticketId){
        ticketBookingService.deleteTicket(ticketId);
    }

    @PutMapping(path = "/ticket/{ticketId}/{newEmail:.+}")
    public Ticket updateTicket(@PathVariable("ticketId") Long ticketId,
                               @PathVariable("newEmail") String newEmail){
        return ticketBookingService.updateTicket(ticketId,newEmail);
    }

}
