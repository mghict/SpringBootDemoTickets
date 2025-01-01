package com.example.demo.entities.ticket;

import com.example.demo.services.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TicketSeed implements CommandLineRunner {

    @Autowired
    private TicketBookingService ticketBookingService;

    @Override
    public void run(String... args) throws Exception {
        Ticket ticket=new Ticket("Mostafa Gharali",
                new Date(),
                "Tehran",
                "Magdeburg",
                "mgh.ict@gmail.com");
        ticketBookingService.createTicket(ticket);
    }
}
