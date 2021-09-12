package com.chameleon.assignment.model;

import lombok.Data;

import java.util.List;

@Data
public class Job {

  private String title;
  private String jobDescription;
  private Company company;
  private String location;
  private List<String> skills;

  public void setTitle(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public String getJobDescription() {
    return jobDescription;
  }

  public Company getCompany() {
    return company;
  }

  public String getLocation() {
    return location;
  }

  public List<String> getSkills() {
    return skills;
  }

  public void setJobDescription(String jobDescription) {
    this.jobDescription = jobDescription;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public void setSkills(List<String> skills) {
    this.skills = skills;
  }
}
