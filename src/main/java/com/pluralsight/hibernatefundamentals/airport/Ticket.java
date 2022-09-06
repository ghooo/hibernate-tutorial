package com.pluralsight.hibernatefundamentals.airport;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "TICKETS")
@IdClass(TicketKey.class)
@Getter
@Setter
@NoArgsConstructor
public class Ticket {
  @Id
  private String series;
  private String number;

  private String origin;
  private String destination;

  @ManyToMany
  @Setter(AccessLevel.NONE)
  private List<Passenger> passengers = new ArrayList<>();

  public List<Passenger> getPassengers() {
    return Collections.unmodifiableList(passengers);
  }

  public void addPassenger(Passenger passenger) {
    passengers.add(passenger);
  }
}
