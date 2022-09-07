package com.pluralsight.hibernatefundamentals.airport;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TICKETS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TICKET_TYPE")
@Getter
@Setter
@NoArgsConstructor
public abstract class Ticket {

  @Setter(AccessLevel.NONE)
  @Id
  @GeneratedValue
  private int id;

  private String number;

  @ManyToOne
  @JoinColumn(name = "passenger_id")
  private Passenger passenger;
}
