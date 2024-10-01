package com.jss.JobService.JobService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long JobId;
  private String jobTitle;
  private String location;
  private String description;
  private Double experience;
  private Double salary;
  private Integer noticePeriod;
  private String contactEmail;
  private String status;

  private Long employerId;
}
