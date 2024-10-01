package com.jss.JobService.JobService.Client;

import com.jss.JobService.JobService.Dto.EmployerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="employer-service",url="http://localhost:8080")

public interface EmployerClient {
    @GetMapping("/employer/{id}")
    EmployerDto getEmployerById(@PathVariable("id") Long id);
}
