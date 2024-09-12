package com.test.common.translation.exception;

public class TranslationException extends RuntimeException {

    public TranslationException(String message, Throwable cause) {
        super(message, cause);
    }

    public TranslationException(String message) {
        super(message);
    }
}
