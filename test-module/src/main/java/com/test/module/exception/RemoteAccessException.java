package com.test.module.exception;

public class RemoteAccessException extends RuntimeException{
    public RemoteAccessException(String message) {
        super(message);
    }
}
