package com.chameleon.assignment.api;

import com.chameleon.assignment.model.Job;
import com.chameleon.assignment.model.JobRequest;
import com.chameleon.assignment.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/jobs")
public class JobController {

  @Autowired
  JobService jobService;

  @PostMapping
  public List<Job> findJobs(@RequestBody JobRequest jobRequest) {
    return jobService.fetchJobs(jobRequest);
  }

}
