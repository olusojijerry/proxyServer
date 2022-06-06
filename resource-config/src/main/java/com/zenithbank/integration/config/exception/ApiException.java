package com.zenithbank.integration.config.exception;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
