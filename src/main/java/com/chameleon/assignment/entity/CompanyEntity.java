package com.chameleon.assignment.entity;

import javax.persistence.*;

@Entity
@Table(name = "company")
public class CompanyEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column(unique = true)
  private String name;
  private Integer employeeStrength;
  private Integer foundedIn;
  private String about;

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Integer getEmployeeStrength() {
    return employeeStrength;
  }

  public Integer getFoundedIn() {
    return foundedIn;
  }

  public String getAbout() {
    return about;
  }
}
