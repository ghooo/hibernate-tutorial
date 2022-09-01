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
  @Id
  @Column(name = "ID")
  private int id;

  @Column(name = "NUMBER")
  private String number;

  @ManyToOne
  @JoinColumn(name = "PASSENGER_ID")
  private Passenger passenger;

  public Ticket(int id, String number) {
    this.id = id;
    this.number = number;
  }
}
