package com.pluralsight.hibernatefundamentals.airport;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PAYMENTS")
@Getter
@Setter
@NoArgsConstructor
public class Payment {
  @Id
  @GeneratedValue
  private int id;

//  @ManyToOne
//  @JoinColumns({
//    @JoinColumn(name = "TICKET_ID", referencedColumnName = "ID"),
//    @JoinColumn(name = "TICKET_NUMBER", referencedColumnName = "NUMBER")
//  })
//  private Ticket ticket;

  private int amount;
}
