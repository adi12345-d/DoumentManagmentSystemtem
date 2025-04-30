package com.document.dmdemo.exception;

public class DocumentNotFoundException extends RuntimeException {
    public DocumentNotFoundException(String documentId) {
        super("Document not found with ID: " + documentId);
    }
}