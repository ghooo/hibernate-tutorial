package com.pluralsight.hibernatefundamentals.airport;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class ReturnTicket extends Ticket{
  private LocalDate latestReturnDate;
}
