package com.Jobsearchsystem.employer_service.Service;

import com.Jobsearchsystem.employer_service.Exception.EmployerNotFoundException;
import com.Jobsearchsystem.employer_service.Exception.InvalidCredentialsException;
import com.Jobsearchsystem.employer_service.entity.Employer;

import java.util.List;

public interface EmployerService {
    Employer registerEmployer(Employer employer);
    Employer loginEmployer(String userName,String password) throws InvalidCredentialsException, EmployerNotFoundException;

    List<Employer>getAllEmployers();

    Employer getEmployerById(Long id) throws EmployerNotFoundException;

}
