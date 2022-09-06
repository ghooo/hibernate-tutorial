package com.pluralsight.hibernatefundamentals.airport;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Ticket {
  private String number;
}
