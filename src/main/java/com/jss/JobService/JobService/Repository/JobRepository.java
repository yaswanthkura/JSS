package com.jss.JobService.JobService.Repository;

import com.jss.JobService.JobService.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job,Long> {

    List<Job> findByEmployerId(Long employerId);
}
