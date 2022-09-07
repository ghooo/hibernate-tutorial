package com.pluralsight.hibernatefundamentals.airport;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "COUNTRIES")
@Getter
@Setter
@NoArgsConstructor
public class Country {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private int id;

  @Column(name = "NAME")
  private String name;

  public Country(String name, String codeName) {
    this.name = name;
    this.codeName = codeName;
  }

  @Column(name = "CODE_NAME")
  private String codeName;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Country country = (Country) o;
    return Objects.equals(name, country.name) && Objects.equals(codeName, country.codeName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, codeName);
  }
}
