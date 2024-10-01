package com.jss.JobService.JobService.Service;

import com.jss.JobService.JobService.Dto.EmployerDto;
import com.jss.JobService.JobService.Entity.Job;
import com.jss.JobService.JobService.Exception.ResourceNotFoundException;

import java.util.List;

public interface JobService {

   public Job postJob(Job job);
    public boolean EditJob(Long JobId,Job jobDetails) throws ResourceNotFoundException;

    void deleteJob(Long jobId) throws ResourceNotFoundException;

    List<Job>getAllJobsByEmployer(Long employerId);

    EmployerDto getEmployer(Long id);
}
