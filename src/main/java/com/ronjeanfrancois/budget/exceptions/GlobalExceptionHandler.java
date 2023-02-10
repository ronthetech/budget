package com.ronjeanfrancois.budget.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorObject> handleDataNotFoundException(DataNotFoundException ex, WebRequest request){
        ErrorObject errorObject = new ErrorObject();

        errorObject.setErrorCode(HttpStatus.NOT_FOUND.value());
        errorObject.setMessage(ex.getMessage());

        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND);
    }
}
