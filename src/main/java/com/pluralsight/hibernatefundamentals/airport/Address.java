package com.pluralsight.hibernatefundamentals.airport;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Address {
  private String street;
  private String number;
  private String zipCode;
  private String city;
}
