package com.document.dmdemo.exception;

public class InvalidTagException extends Exception {

    // Constructor that accepts a custom message
    public InvalidTagException(String message) {
        super(message);
    }

    // Constructor that accepts a custom message and a cause
    public InvalidTagException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor that accepts a cause
    public InvalidTagException(Throwable cause) {
        super(cause);
    }
}