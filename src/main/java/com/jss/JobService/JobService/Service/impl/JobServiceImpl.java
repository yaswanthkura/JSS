package com.jss.JobService.JobService.Service.impl;

import com.jss.JobService.JobService.Client.EmployerClient;
import com.jss.JobService.JobService.Dto.EmployerDto;
import com.jss.JobService.JobService.Entity.Job;
import com.jss.JobService.JobService.Exception.ResourceNotFoundException;
import com.jss.JobService.JobService.Repository.JobRepository;
import com.jss.JobService.JobService.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private final EmployerClient employerClient;

    public JobServiceImpl(EmployerClient employerClient){

        this.employerClient=employerClient;
    }

    public EmployerDto getEmployer(Long employerId){

        return employerClient.getEmployerById(employerId);
    }

    @Autowired
    private JobRepository jobRepository;
    @Override
    public Job postJob(Job job) {

        return jobRepository.save(job);
    }

    @Override
    public boolean EditJob(Long JobId, Job jobDetails) throws ResourceNotFoundException {
        Job existingJob = jobRepository.findById(JobId)
                .orElseThrow(() -> new ResourceNotFoundException("Job Not Found"));

        // Check for each field and update only if not null
        if (jobDetails.getJobTitle() != null) {
            existingJob.setJobTitle(jobDetails.getJobTitle());
        }
        if (jobDetails.getDescription() != null) {
            existingJob.setDescription(jobDetails.getDescription());
        }
        if (jobDetails.getLocation() != null) {
            existingJob.setLocation(jobDetails.getLocation());
        }
        if (jobDetails.getSalary() != null) {
            existingJob.setSalary(jobDetails.getSalary());
        }
        if (jobDetails.getExperience() != null) {
            existingJob.setExperience(jobDetails.getExperience());
        }
        if (jobDetails.getNoticePeriod() != null) {
            existingJob.setNoticePeriod(jobDetails.getNoticePeriod());
        }
        if (jobDetails.getContactEmail() != null) {
            existingJob.setContactEmail(jobDetails.getContactEmail());
        }
        if (jobDetails.getStatus() != null) {
            existingJob.setStatus(jobDetails.getStatus());
        }

        jobRepository.save(existingJob);
        return true; // Indicate the update was successful
    }


    @Override
    public void deleteJob(Long jobId) throws ResourceNotFoundException {
    Job exsistingJob=    jobRepository.findById(jobId).orElseThrow(()-> new ResourceNotFoundException("Id with"+jobId+"not present"));
    jobRepository.delete(exsistingJob);


    }

    @Override
    public List<Job> getAllJobsByEmployer(Long employerId) {

        return jobRepository.findByEmployerId(employerId);
    }


}
