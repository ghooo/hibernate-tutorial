package com.pluralsight.hibernatefundamentals;

import com.pluralsight.hibernatefundamentals.airport.Airport;
import com.pluralsight.hibernatefundamentals.airport.Passenger;
import com.pluralsight.hibernatefundamentals.airport.Ticket;
import com.pluralsight.hibernatefundamentals.airport.TicketKey;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m02.ex01");
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    Airport airport = new Airport(1, "Henri Caonda");
    Passenger john = new Passenger(1, "John Smith");
    john.setCity("Kirkland");
    john.setStreet("100th AVE NE");
    john.setNumber("1234");
    john.setZipCode("98034");
    john.setAreaCode("425");
    john.setPrefix("123");
    john.setLineNumber("4567");

    john.setAirport(airport);
    Passenger mike = new Passenger(2, "Michael Johnson");
    mike.setAirport(airport);
    airport.addPassenger(john);
    airport.addPassenger(mike);


    Ticket ticket1 = new Ticket();
    ticket1.setSeries("AA");
    ticket1.setNumber("1234");
    ticket1.setOrigin("Seattle");
    ticket1.setDestination("Cairo");
    ticket1.setPassenger(john);
    john.addTicket(ticket1);

    Ticket ticket2 = new Ticket();
    ticket2.setSeries("BB");
    ticket2.setNumber("5678");
    ticket2.setPassenger(john);
    john.addTicket(ticket2);

//    Ticket ticket3 = new Ticket(3, "CC5678");
//    ticket3.setPassenger(mike);
//    mike.addTicket(ticket3);

    em.persist(airport);

    em.persist(john);
    em.persist(mike);

    em.persist(ticket1);
    em.persist(ticket2);
//    em.persist(ticket3);

    em.getTransaction().commit();
    emf.close();
  }
}
