package com.example.demo.JWT.common;

public class AccessDeniedException extends RuntimeException{

    public AccessDeniedException(String message){
        super(message);
    }
}
