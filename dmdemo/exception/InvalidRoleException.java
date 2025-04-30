package com.document.dmdemo.exception;

public class InvalidRoleException extends Exception {

    // Constructor with no arguments
    public InvalidRoleException() {
        super("Invalid role specified.");
    }

    // Constructor that accepts a custom message
    public InvalidRoleException(String message) {
        super(message);
    }

    // Constructor that accepts a custom message and a cause
    public InvalidRoleException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor that accepts a cause
    public InvalidRoleException(Throwable cause) {
        super(cause);
    }
}