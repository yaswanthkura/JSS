package com.jss.JobService.JobService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.jss.JobService.JobService.Client")
public class JobServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(JobServiceApplication.class, args);
	}

}
