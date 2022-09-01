package com.pluralsight.hibernatefundamentals.airport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

  @ManyToOne
  @JoinColumn(name = "PASSENGER_ID")
  private Passenger passenger;
}
