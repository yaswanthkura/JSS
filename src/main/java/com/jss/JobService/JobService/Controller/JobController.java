package com.jss.JobService.JobService.Controller;

import com.jss.JobService.JobService.Client.EmployerClient;
import com.jss.JobService.JobService.Dto.EmployerDto;
import com.jss.JobService.JobService.Dto.ResponseDto;
import com.jss.JobService.JobService.Entity.Job;
import com.jss.JobService.JobService.Exception.ResourceNotFoundException;
import com.jss.JobService.JobService.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/Job")
public class JobController {
    @Autowired
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/employer/{id}")
    public ResponseEntity<EmployerDto> getEmployer(@PathVariable("id") Long id) {
        EmployerDto employer = jobService.getEmployer(id);
        return ResponseEntity.ok(employer);
    }

    @PostMapping("/post")
    public ResponseEntity<ResponseDto> postJob(@RequestBody Job job) {
        Job postedJob = jobService.postJob(job);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(HttpStatus.CREATED, "Job posted successfully"));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ResponseDto> editJob(@PathVariable Long id, @RequestBody Job JobDetails) throws ResourceNotFoundException {
        boolean isUpdated = jobService.EditJob(id, JobDetails);
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto(HttpStatus.OK, "UPDATED"));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(HttpStatus.INTERNAL_SERVER_ERROR, "NotUpdated"));
        }


    }

    @DeleteMapping("/delete/{jobId}")
    public ResponseEntity<ResponseDto> deleteJob(@PathVariable long jobId) throws ResourceNotFoundException {
        jobService.deleteJob(jobId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK, "Deleted Successfully"));
    }

    @GetMapping("/all/{employerId}")
    public ResponseEntity<List<Job>> getAllJobsByEmployer(@PathVariable("employerId") Long employerId) throws ResourceNotFoundException {
        List<Job> jobs = jobService.getAllJobsByEmployer(employerId);

        if (jobs == null || jobs.isEmpty()) {
            throw new ResourceNotFoundException("Jobs not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(jobs);
    }
}