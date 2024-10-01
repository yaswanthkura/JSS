package com.jss.JobService.JobService.Exception;

import com.jss.JobService.JobService.Dto.ErrorDto;
import org.apache.tomcat.util.file.ConfigurationSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleGlobalException(Exception ex, WebRequest webRequest){
        ErrorDto errorDto=new ErrorDto(
                webRequest.getDescription(false),
        HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage(),
                LocalDateTime.now()


        );

    return new ResponseEntity<>(errorDto,HttpStatus.INTERNAL_SERVER_ERROR);
    }
     @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDto>handleResourceNotFoundException(ResourceNotFoundException ex,WebRequest webRequest){
        ErrorDto errorDto=new ErrorDto(
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                LocalDateTime.now()

        );
        return new ResponseEntity<>(errorDto,HttpStatus.NOT_FOUND);

    }



}
