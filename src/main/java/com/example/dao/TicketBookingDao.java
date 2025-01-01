package com.example.dao;

import com.example.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketBookingDao extends JpaRepository<Ticket,Long> {

}
