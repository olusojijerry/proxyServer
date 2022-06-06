package com.zenithbank.integration.config.exception;

public class AuthorisationErrorException extends RuntimeException{
    public AuthorisationErrorException(String message){
        super(message);
    }
}
