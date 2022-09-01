package com.pluralsight.hibernatefundamentals.airport;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "AIRPORTS")
@Access(AccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
public class Airport {
  @Id
  @Column(name = "ID")
  private int id;

  @Column(name = "NAME")
  private String name;

  @OneToMany(mappedBy = "airport")
  @Setter(AccessLevel.NONE)
  private List<Passenger> passengers = new ArrayList<>();
  public Airport(int id, String name) {
    this.id = id;
    this.name = name;
  }
  public List<Passenger> getPassengers() {
    return Collections.unmodifiableList(passengers);
  }

  public void addPassenger(Passenger passenger) {
    passengers.add(passenger);
  }
}
