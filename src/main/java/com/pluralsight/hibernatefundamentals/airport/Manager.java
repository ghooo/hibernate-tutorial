package com.pluralsight.hibernatefundamentals.airport;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "MANAGERS")
@Getter
@Setter
@NoArgsConstructor
public class Manager {
  @Id
  @GeneratedValue
  private int id;

  public Manager(String name) {
    this.name = name;
  }

  private String name;

  @OneToOne
  @JoinTable(name = "MANAGER_TO_DEPARTMENT", joinColumns = {
    @JoinColumn(name = "MANAGER_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "ID", nullable = false)})
  private Department department;
}
