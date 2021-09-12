package com.chameleon.assignment.model;

import lombok.Data;

import java.util.List;

public class JobRequest {

  private List<String> skills;
  private List<String> locations;

  public List<String> getSkills() {
    return skills;
  }

  public List<String> getLocations() {
    return locations;
  }
}
