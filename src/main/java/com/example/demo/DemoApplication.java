package com.example.demo;

import com.example.entities.Ticket;
import com.example.services.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class DemoApplication implements CommandLineRunner {

    @Autowired(required = true)
    private TicketBookingService ticketBookingService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Ticket ticket=new Ticket("Mostafa Gharali",
                new Date(),
                "Teheran",
                "Magdeburg",
                "mgh.ict@gmail.com");
        ticketBookingService.createTicket(ticket);
    }
}
