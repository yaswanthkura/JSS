package com.Jobsearchsystem.employer_service.repository;

import com.Jobsearchsystem.employer_service.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<Employer,Long> {
Employer findByUserName(String userName);

}
