package com.pluralsight.hibernatefundamentals.airport;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "PASSENGERS")
@Access(AccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
public class Passenger {

  @Id
  @Column(name = "ID")
  private int id;

  @Column(name = "NAME")
  private String name;

  @ManyToOne
  @JoinColumn(name = "AIRPORT_ID")
  private Airport airport;

  @OneToMany(mappedBy = "passenger")
  @Setter(AccessLevel.NONE)
  private List<Ticket> tickets = new ArrayList<>();

  public Passenger(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public List<Ticket> getTickets() {
    return Collections.unmodifiableList(tickets);
  }

  public void addTicket(Ticket ticket) {
    tickets.add(ticket);
  }

}
