package com.pluralsight.hibernatefundamentals.airport;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ONE_WAY_TICKETS")
public class OneWayTicket extends Ticket{
  private LocalDate latestDepartureDate;
}
