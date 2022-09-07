package com.pluralsight.hibernatefundamentals;

import com.pluralsight.hibernatefundamentals.airport.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

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
    Address address = new Address();
    address.setCity("Kirkland");
    address.setStreet("100th AVE NE");
    address.setNumber("1234");
    address.setZipCode("98034");
    john.setAddress(address);

    john.setAreaCode("425");
    john.setPrefix("123");
    john.setLineNumber("4567");

    john.setAirport(airport);
    Passenger mike = new Passenger(2, "Michael Johnson");
    mike.setAirport(airport);
    airport.addPassenger(john);
    airport.addPassenger(mike);


//    Ticket ticket1 = new Ticket();
//    ticket1.setId("AA");
//    ticket1.setNumber("1234");
//    ticket1.setOrigin("Seattle");
//    ticket1.setDestination("Cairo");
//    ticket1.addPassenger(john);
//    ticket1.addPassenger(mike);
//    john.addTicket(ticket1);

//    Ticket ticket2 = new Ticket();
//    ticket2.setId("BB");
//    ticket2.setNumber("5678");
//    ticket2.addPassenger(john);
//    ticket2.addPassenger(mike);
//    john.addTicket(ticket2);

    john.addAttribute("VIP", "Yes");
    john.addAttribute("FREQUENT_FLYER", "Yes");

    Payment payment = new Payment();
//    payment.setTicket(ticket1);
    payment.setAmount(200);

//    Ticket ticket3 = new Ticket(3, "CC5678");
//    ticket3.setPassenger(mike);
//    mike.addTicket(ticket3);

    Manager ali = new Manager("Ali Ghoneim");
    Department accounting = new Department();
    accounting.setName("Accounting");

    ali.setDepartment(accounting);

    OneWayTicket oneWayTicket = new OneWayTicket();
    oneWayTicket.setNumber("AA1234");
    oneWayTicket.setLatestDepartureDate(LocalDate.of(2021, 3, 20));
    oneWayTicket.setPassenger(john);

    ReturnTicket returnTicket = new ReturnTicket();
    returnTicket.setNumber("BB5678");
    returnTicket.setLatestReturnDate(LocalDate.of(2022, 1, 31));
    returnTicket.setPassenger(john);

    em.persist(oneWayTicket);
    em.persist(returnTicket);
    em.persist(payment);

    em.persist(ali);
    em.persist(accounting);


    em.persist(airport);

    em.persist(john);
    em.persist(mike);

//    em.persist(ticket1);
//    em.persist(ticket2);
//    em.persist(ticket3);

    em.getTransaction().commit();
    emf.close();
  }
}
