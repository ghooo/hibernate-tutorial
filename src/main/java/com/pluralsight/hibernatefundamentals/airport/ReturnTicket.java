package com.pluralsight.hibernatefundamentals.airport;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "RETURN_TICKETS")
public class ReturnTicket extends Ticket{
  private LocalDate latestReturnDate;
}
