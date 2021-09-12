package com.chameleon.assignment.service;

import com.chameleon.assignment.entity.CompanyEntity;
import com.chameleon.assignment.entity.JobEntity;
import com.chameleon.assignment.entity.SkillEntity;
import com.chameleon.assignment.exception.AdvisorException;
import com.chameleon.assignment.model.Company;
import com.chameleon.assignment.model.Job;
import com.chameleon.assignment.model.JobRequest;
import com.chameleon.assignment.repository.JobRepository;
import com.chameleon.assignment.repository.LocationRepository;
import com.chameleon.assignment.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JobService {

  @Autowired
  JobRepository jobRepository;

  @Autowired
  SkillRepository skillRepository;

  @Autowired
  LocationRepository locationRepository;

  public List<Job> fetchJobs(JobRequest jobRequest) {
    List<Integer> locationIds = validateLocations(jobRequest.getLocations());
    List<Integer> skillIds = validateSkills(jobRequest.getSkills());
    List<JobEntity> jobEntities = jobRepository.fetchJobs(locationIds, skillIds);
    if (jobEntities.size() == 0) {
      throw new AdvisorException(HttpStatus.NOT_FOUND.value(), "No Job is found matching your profile");
    }
    return mapEntityListToJobList(jobEntities);
  }

  private List<Job> mapEntityListToJobList(List<JobEntity> jobEntities) {
    List<Job> jobs = new ArrayList<>();
    for (JobEntity jobEntity : jobEntities) {
      jobs.add(mapEntityToJob(jobEntity));
    }
    return jobs;
  }

  private Job mapEntityToJob(JobEntity jobEntity) {
    Job job = new Job();
    job.setTitle(jobEntity.getTitle());
    job.setJobDescription(jobEntity.getJobDescription());
    job.setLocation(jobEntity.getLocation().getName());

    //map company
    CompanyEntity companyEntity = jobEntity.getCompany();
    Company company = new Company();
    company.setName(companyEntity.getName());
    company.setEmployeeStrength(companyEntity.getEmployeeStrength());
    company.setFoundedIn(companyEntity.getFoundedIn());
    company.setAbout(companyEntity.getAbout());
    job.setCompany(company);

    //map skills
    List<String> skills = new ArrayList<>();
    for (SkillEntity skill : jobEntity.getSkills()) {
      skills.add(skill.getName());
    }
    job.setSkills(skills);
    return job;
  }

  private List<Integer> validateLocations(List<String> locations) {
    if (locations.size() == 0) {
      throw new AdvisorException(HttpStatus.BAD_REQUEST.value(), "Preferred locations is mandatory");
    }
    List<String> locationEntries = locations.stream().map(String::toLowerCase).collect(Collectors.toList());
    List<Integer> locationIds = locationRepository.fetchLocationEntities(locationEntries);
    if (locationIds.size() == locations.size()) {
      return locationIds;
    }
    throw new AdvisorException(HttpStatus.BAD_REQUEST.value(), "Invalid Locations");
  }

  private List<Integer> validateSkills(List<String> skills) {
    if (skills.size() == 0) {
      throw new AdvisorException(HttpStatus.BAD_REQUEST.value(), "Acquired skills is mandatory");
    }
    List<String> skillEntries = skills.stream().map(String::toLowerCase).collect(Collectors.toList());
    List<Integer> skillIds = skillRepository.fetchSkillEntities(skillEntries);
    if (skillIds.size() == skills.size()) {
      return skillIds;
    }
    throw new AdvisorException(HttpStatus.BAD_REQUEST.value(), "Invalid Skills");
  }

}
