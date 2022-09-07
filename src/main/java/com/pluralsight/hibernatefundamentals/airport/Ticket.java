package com.pluralsight.hibernatefundamentals.airport;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TICKETS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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
