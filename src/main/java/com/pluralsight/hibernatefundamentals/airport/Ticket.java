package com.pluralsight.hibernatefundamentals.airport;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TICKETS")
public abstract class Ticket {
  @Setter(AccessLevel.NONE)
  @Id
  @GeneratedValue
  private int id;
  private String number;
}
