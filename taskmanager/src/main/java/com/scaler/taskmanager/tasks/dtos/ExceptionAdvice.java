package com.scaler.taskmanager.tasks.dtos;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(
            {
                    HttpMessageNotReadableException.class,
                    IllegalArgumentException.class
            }
    )
    ResponseEntity<String> multiExceptionHandler(Exception e) {
        if(e instanceof HttpMessageNotReadableException) {
            return ResponseEntity.badRequest().body("Invalid request body");
        } else if (e instanceof IllegalArgumentException) {
            return ResponseEntity.internalServerError().body("Illegal Argument");
        } else {
            return ResponseEntity.internalServerError().body("idk - something wrong happened");
        }
    }
}
