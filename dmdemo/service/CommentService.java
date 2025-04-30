package com.document.dmdemo.service;

import com.document.dmdemo.exception.InvalidCommentException;
import com.document.dmdemo.model.CommentEntity;

import java.util.List;

public interface CommentService {
    CommentEntity addComment(CommentEntity comment);
    CommentEntity updateComment(CommentEntity comment) throws InvalidCommentException;
    void deleteComment(Long commentId);
    List<CommentEntity> getCommentsByDocumentId(Long documentId);

    List<CommentEntity> getAllComments();

    CommentEntity getCommentById(Long commentId);
}