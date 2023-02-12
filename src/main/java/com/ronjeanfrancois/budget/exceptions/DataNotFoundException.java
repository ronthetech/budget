package com.ronjeanfrancois.budget.exceptions;

public class DataNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1;

    public DataNotFoundException(String message){
        super(message);
    }
}
