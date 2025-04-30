package com.document.dmdemo.exception;

public class MetadataNotFoundException extends RuntimeException {
    public MetadataNotFoundException(String metadataId) {
        super("Metadata not found with ID: " + metadataId);
    }
}