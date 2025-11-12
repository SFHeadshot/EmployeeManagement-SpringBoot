package com.example.EmployeeManagement.controllers;

import com.example.EmployeeManagement.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // Class Contains logic that needs to be applied globally across all @RestController and @Controller
public class RESTExceptionHandler {

    // Custom Exception Handler to handle EmployeeNotFoundException
    @ExceptionHandler(EmployeeNotFoundException.class) // Marking method as specific handler for exception
    public ResponseEntity<String> handleNotFound(EmployeeNotFoundException ex){
        // Return the exception message with an HTTP status of 404 NOT FOUND
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
