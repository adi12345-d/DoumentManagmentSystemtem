package com.document.dmdemo.exception;

public class CommentNotFoundException extends RuntimeException {
    public CommentNotFoundException(String commentId) {
        super("Comment not found with ID: " + commentId);
    }
}