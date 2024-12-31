package com.example.entities;

import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;

import java.util.Date;

//@Getter
//@Setter
@Entity
@Table()
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ticket_id")
    private Long id;

    @Column(name="passenger_name",nullable = false)
    private String passengerName;

    @Column(name="booking_date")
    private Date bookingDate;

    @Column(name="source_station")
    private String sourceStation;

    @Column(name="dest_station")
    private String destStation;

    @Column(name="email")
    private String email;


    protected Ticket()
    {

    }

    public Ticket(String passengerName, Date bookingDate, String sourceStation, String destStation, String email) {
        this.passengerName = passengerName;
        this.bookingDate = bookingDate;
        this.sourceStation = sourceStation;
        this.destStation = destStation;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getSourceStation() {
        return sourceStation;
    }

    public void setSourceStation(String sourceStation) {
        this.sourceStation = sourceStation;
    }

    public String getDestStation() {
        return destStation;
    }

    public void setDestStation(String destStation) {
        this.destStation = destStation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
