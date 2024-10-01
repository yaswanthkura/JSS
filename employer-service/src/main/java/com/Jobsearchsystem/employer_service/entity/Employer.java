package com.Jobsearchsystem.employer_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employer {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String organizationName;
    private String address;
    private String contactNo;
    private String email;
    private String userName;
    private String password;
}
