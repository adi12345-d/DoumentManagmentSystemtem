package com.document.dmdemo.exception;

public class IngestionProcessNotFoundException extends RuntimeException {
    public IngestionProcessNotFoundException(String ingestionProcessId) {
        super("Ingestion process not found with ID: " + ingestionProcessId);
    }
}