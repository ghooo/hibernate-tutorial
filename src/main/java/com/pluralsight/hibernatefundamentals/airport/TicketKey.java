package com.pluralsight.hibernatefundamentals.airport;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class TicketKey implements Serializable {
  private String series;
  private String number;
}
