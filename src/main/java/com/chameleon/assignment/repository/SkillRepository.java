package com.chameleon.assignment.repository;

import com.chameleon.assignment.entity.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface SkillRepository extends JpaRepository<SkillEntity, Integer> {

  @Query("select skill.id from SkillEntity skill where skill.name IN ?1")
  List<Integer> fetchSkillEntities(List<String> skills);

}
