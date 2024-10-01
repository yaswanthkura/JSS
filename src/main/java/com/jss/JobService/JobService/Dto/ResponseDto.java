package com.jss.JobService.JobService.Dto;

import com.jss.JobService.JobService.Entity.Job;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseDto {
    private HttpStatus ResponseStatus;
    private String ResponseMessage;

}
