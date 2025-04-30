package com.document.dmdemo.exception; // Adjust the package name as needed

public class InvalidDocumentException extends Exception {

    // Default constructor
    public InvalidDocumentException() {
        super("Invalid document provided.");
    }

    // Constructor that accepts a custom message
    public InvalidDocumentException(String message) {
        super(message);
    }

    // Constructor that accepts a custom message and a cause
    public InvalidDocumentException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor that accepts a cause
    public InvalidDocumentException(Throwable cause) {
        super(cause);
    }
}