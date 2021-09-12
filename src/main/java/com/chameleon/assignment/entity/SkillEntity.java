package com.chameleon.assignment.entity;

import javax.persistence.*;

@Entity
@Table(name = "skill")
public class SkillEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column(unique = true)
  private String name;

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
