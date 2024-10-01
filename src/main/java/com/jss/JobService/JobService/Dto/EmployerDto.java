package com.jss.JobService.JobService.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerDto {
    private Long id;
    private String organizationName;
    private String address;
    private String contactNo;
    private String email;
    private String userName;

}
