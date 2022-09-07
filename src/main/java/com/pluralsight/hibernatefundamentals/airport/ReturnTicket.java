package com.pluralsight.hibernatefundamentals.airport;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.AssociationOverride;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "RETURN_TICKETS")
@AssociationOverride(name = "passengers", joinColumns = @JoinColumn(name = "pass_id"))
public class ReturnTicket extends Ticket{
  private LocalDate latestReturnDate;
}
