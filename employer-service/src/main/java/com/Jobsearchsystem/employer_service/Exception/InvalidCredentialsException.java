package com.Jobsearchsystem.employer_service.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidCredentialsException extends Exception {
    public InvalidCredentialsException(String message){
        super(message);
    }
}
