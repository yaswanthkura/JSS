package com.Jobsearchsystem.employer_service.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ResponseDto {
    HttpStatus statusCode;
    String statusMessage;

}
