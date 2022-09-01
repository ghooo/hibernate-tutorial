package com.pluralsight.hibernatefundamentals.airport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TICKETS")
@Getter
@Setter
@NoArgsConstructor
public class Ticket {
  @EmbeddedId
  private TicketKey id;
  private String origin;
  private String destination;

  @ManyToOne
  @JoinColumn(name = "PASSENGER_ID")
  private Passenger passenger;
}
