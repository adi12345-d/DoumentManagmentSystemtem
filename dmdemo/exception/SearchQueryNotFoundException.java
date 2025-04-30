package com.document.dmdemo.exception;

public class SearchQueryNotFoundException extends RuntimeException {
    public SearchQueryNotFoundException(String searchQueryId) {
        super("Search query not found with ID: " + searchQueryId);
    }
}