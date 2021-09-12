package com.chameleon.assignment.model;

import lombok.Data;

@Data
public class Company {

  private String name;
  private int employeeStrength;
  private int foundedIn;
  private String about;

  public String getName() {
    return name;
  }

  public int getEmployeeStrength() {
    return employeeStrength;
  }

  public int getFoundedIn() {
    return foundedIn;
  }

  public String getAbout() {
    return about;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmployeeStrength(int employeeStrength) {
    this.employeeStrength = employeeStrength;
  }

  public void setFoundedIn(int foundedIn) {
    this.foundedIn = foundedIn;
  }

  public void setAbout(String about) {
    this.about = about;
  }
}
