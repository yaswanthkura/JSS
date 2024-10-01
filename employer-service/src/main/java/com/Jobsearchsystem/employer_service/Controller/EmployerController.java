package com.Jobsearchsystem.employer_service.Controller;

import com.Jobsearchsystem.employer_service.Dto.ResponseDto;
import com.Jobsearchsystem.employer_service.Exception.EmployerNotFoundException;
import com.Jobsearchsystem.employer_service.Exception.InvalidCredentialsException;
import com.Jobsearchsystem.employer_service.Service.EmployerService;
import com.Jobsearchsystem.employer_service.entity.Employer;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employer")
@Log4j2
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> registerEmployer(@RequestBody Employer employer) {
        try {
            log.info("Registering employer with email: {}", employer.getEmail());
            Employer registeredEmployer = employerService.registerEmployer(employer);
            log.info("Employer registered successfully with ID: {}", registeredEmployer.getId());
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ResponseDto(HttpStatus.CREATED, "User Registration successful"));
        } catch (Exception e) {
            log.error("Error occurred during employer registration: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(HttpStatus.INTERNAL_SERVER_ERROR, "User Registration failed"));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDto> loginEmployer(@RequestParam String userName, @RequestParam String password) {
        try {
            log.info("Attempting login for username: {}", userName);
            employerService.loginEmployer(userName, password);
            log.info("Login successful for username: {}", userName);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto(HttpStatus.OK, "Login Successful!!!"));
        } catch (EmployerNotFoundException e) {
            log.error("Login failed for username: {} - Employer not found", userName, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseDto(HttpStatus.NOT_FOUND, e.getMessage()));
        } catch (InvalidCredentialsException e) {
            log.error("Login failed for username: {} - Invalid credentials", userName, e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ResponseDto(HttpStatus.UNAUTHORIZED, e.getMessage()));
        } catch (Exception e) {
            log.error("Error occurred during login for username: {}: {}", userName, e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(HttpStatus.INTERNAL_SERVER_ERROR, "Login failed"));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employer>> getAllEmployers() {
        try {
            log.info("Fetching all employers");
            List<Employer> employers = employerService.getAllEmployers();
            log.info("'Number of employers fetched: {}", employers.size());
            return ResponseEntity.status(HttpStatus.OK)
                    .body(employers);
        } catch (Exception e) {
            log.error("Error occurred while fetching all employers: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employer>getEmployerById(@PathVariable("id") Long id) throws EmployerNotFoundException {
    try {
        Employer employer = employerService.getEmployerById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employer);
    }
    catch(EmployerNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }
    catch (Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
    }
}
