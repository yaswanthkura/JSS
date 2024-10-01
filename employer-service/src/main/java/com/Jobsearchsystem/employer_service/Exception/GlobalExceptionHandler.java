package com.Jobsearchsystem.employer_service.Exception;

import com.Jobsearchsystem.employer_service.Dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto>handleGlobalException(Exception ex, WebRequest webRequest){
        ErrorDto errorDto;
        errorDto=new ErrorDto(
                webRequest.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage(),
                LocalDateTime.now()

        );
    return new ResponseEntity<>(errorDto,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(EmployerNotFoundException.class)
    public ResponseEntity<ErrorDto>handleEmployerNotFoundException(EmployerNotFoundException employerNotFoundException,WebRequest webRequest){

       ErrorDto  response=new ErrorDto(
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                employerNotFoundException.getMessage(),
                LocalDateTime.now()


        );
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);






    }
    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ErrorDto>handleInvalidException(InvalidCredentialsException ex,WebRequest webRequest){
        ErrorDto response=new ErrorDto(
                webRequest.getDescription(false),
                HttpStatus.UNAUTHORIZED,
                ex.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(response,HttpStatus.UNAUTHORIZED);
    }

}
