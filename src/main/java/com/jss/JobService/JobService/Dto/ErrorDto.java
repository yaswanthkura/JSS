package com.jss.JobService.JobService.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorDto {
    private String apiPath;
    private HttpStatus statusCode;
    private String statusMessage;
    private LocalDateTime errorTime;
}
