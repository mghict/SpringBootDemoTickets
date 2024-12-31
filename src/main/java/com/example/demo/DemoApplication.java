package com.example.demo;

import com.example.entities.Ticket;
import com.example.services.TicketBookingService;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext appContext= SpringApplication.run(DemoApplication.class, args);

        TicketBookingService ticketBookingService = appContext.getBean("ticketBookingService",TicketBookingService.class);
        Ticket ticket=new Ticket("Mostafa Gharali",
                                  new Date(),
                                 "Teheran",
                                 "Magdeburg",
                                 "mgh.ict@gmail.com");
        ticketBookingService.createTicket(ticket);

    }

}
