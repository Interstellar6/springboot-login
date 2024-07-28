package com.interstellar.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.MethodNotAllowedException;

@RequestMapping("/error")
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodNotAllowedException.class)
    public ResponseEntity<String> handleMethodNotAllowed(MethodNotAllowedException ex) {
        return new ResponseEntity<>("Interstellar: Method Not Allowed: " + ex.getMessage(), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>("Interstellar: An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

