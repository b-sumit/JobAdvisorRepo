package com.chameleon.assignment.repository;

import com.chameleon.assignment.entity.JobEntity;
import com.chameleon.assignment.entity.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, Integer> {

  @Query("select job from JobEntity job where job.location.id IN ?1 and " +
          "(select COUNT(*) from job.skills s where s.id NOT IN ?2) = 0")
  List<JobEntity> fetchJobs(List<Integer> locations, List<Integer> skills);


}
