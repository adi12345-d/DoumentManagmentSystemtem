package com.document.dmdemo.exception;

public class TagNotFoundException extends RuntimeException {
    public TagNotFoundException(String tagId) {
        super("Tag not found with ID: " + tagId);
    }
}