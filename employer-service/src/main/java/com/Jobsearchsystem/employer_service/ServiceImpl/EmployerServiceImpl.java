package com.Jobsearchsystem.employer_service.ServiceImpl;

import com.Jobsearchsystem.employer_service.Exception.EmployerNotFoundException;
import com.Jobsearchsystem.employer_service.Exception.InvalidCredentialsException;
import com.Jobsearchsystem.employer_service.Service.EmployerService;
import com.Jobsearchsystem.employer_service.entity.Employer;
import com.Jobsearchsystem.employer_service.repository.EmployerRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class EmployerServiceImpl implements EmployerService {
    @Autowired
private EmployerRepository employerRepository;
    @Override
    public Employer registerEmployer(Employer employer) {
        log.info("Register Employer with email:{}",employer.getEmail());
    Employer registeredEmployer= employerRepository.save(employer);
    log.info("Employer registered with ID:{}",employer.getId());
    return registeredEmployer;
    }

    @Override
    public Employer loginEmployer(String userName, String password) throws InvalidCredentialsException, EmployerNotFoundException {
        log.info("Attempting login for username: {}", userName);
        Employer employer=employerRepository.findByUserName(userName);
        if(employer==null){
            log.error("Employer not found with username: {}", userName);
            throw new EmployerNotFoundException("Employer not found with username: " + userName);
        }
        if(!employer.getPassword().equals(password)){
            log.error("Invalid credentials for username: {}", userName);
            throw new InvalidCredentialsException("Invalid credentials for username: " + userName);
        }
        log.info("Login successful for employer:{}",userName);
        return employer;
    }

    @Override
    public List<Employer> getAllEmployers() {
        log.info("Fetching all employers");
      List<Employer>employers=  employerRepository.findAll();
        log.info("Number of employers fetched: {}", employers.size());
        return  employers;
    }

    @Override
    public Employer getEmployerById(Long id) throws EmployerNotFoundException {
     return   employerRepository.findById(id).orElseThrow(()->new EmployerNotFoundException("Employer not found"));
    }
}
