package com.document.dmdemo.exception; // Adjust the package name as needed

public class InvalidCommentException extends Exception {

    // Default constructor
    public InvalidCommentException() {
        super("Invalid comment provided.");
    }

    // Constructor that accepts a custom message
    public InvalidCommentException(String message) {
        super(message);
    }

    // Constructor that accepts a custom message and a cause
    public InvalidCommentException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor that accepts a cause
    public InvalidCommentException(Throwable cause) {
        super(cause);
    }
}