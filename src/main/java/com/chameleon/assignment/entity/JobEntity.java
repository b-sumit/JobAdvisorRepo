package com.chameleon.assignment.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "job", uniqueConstraints = {@UniqueConstraint(columnNames = {"title", "company_id", "location_id"})})
public class JobEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String title;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "company_id")
  private CompanyEntity company;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "location_id")
  private LocationEntity location;
  @ManyToMany(fetch = FetchType.LAZY)
  private Set<SkillEntity> skills;
  private String jobDescription;

  public Integer getId() {
    return id;
  }
  public String getTitle() {
    return title;
  }

  public CompanyEntity getCompany() {
    return company;
  }

  public LocationEntity getLocation() {
    return location;
  }

  public Set<SkillEntity> getSkills() {
    return skills;
  }

  public String getJobDescription() {
    return jobDescription;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setCompany(CompanyEntity company) {
    this.company = company;
  }

  public void setLocation(LocationEntity location) {
    this.location = location;
  }

  public void setSkills(Set<SkillEntity> skills) {
    this.skills = skills;
  }

  public void setJobDescription(String jobDescription) {
    this.jobDescription = jobDescription;
  }
}
