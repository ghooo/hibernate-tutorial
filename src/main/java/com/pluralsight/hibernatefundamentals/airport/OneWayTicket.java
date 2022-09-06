package com.pluralsight.hibernatefundamentals.airport;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class OneWayTicket extends Ticket{
  private LocalDate latestDepartureDate;
}
