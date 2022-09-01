package com.pluralsight.hibernatefundamentals.airport;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "PASSENGERS")
@SecondaryTable(name = "ADDRESSES",
  pkJoinColumns = @PrimaryKeyJoinColumn(name = "PASSENGER_ID", referencedColumnName = "ID"))
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

  @Column(name = "PASSENGER_ADDRESS", table = "ADDRESSES", columnDefinition = "varchar(25) not null")
  private String address;

  @ManyToOne
  @JoinColumn(name = "AIRPORT_ID")
  private Airport airport;

  @OneToMany(mappedBy = "passenger")
  @Setter(AccessLevel.NONE)
  private List<Ticket> tickets = new ArrayList<>();

  public Passenger(int id, String name) {
    this(id, name, "N/A");
  }

  public Passenger(int id, String name, String address) {
    this.id = id;
    this.name = name;
    this.address = address;
  }

  public List<Ticket> getTickets() {
    return Collections.unmodifiableList(tickets);
  }

  public void addTicket(Ticket ticket) {
    tickets.add(ticket);
  }

}
