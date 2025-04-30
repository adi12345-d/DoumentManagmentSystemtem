package com.document.dmdemo.serviceImpl;

import com.document.dmdemo.exception.CommentNotFoundException;
import com.document.dmdemo.exception.InvalidCommentException;
import com.document.dmdemo.model.CommentEntity;
import com.document.dmdemo.repo.CommentRepository;
import com.document.dmdemo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public CommentEntity saveComment(CommentEntity comment) throws InvalidCommentException {
        validateComment(comment);
        return commentRepository.save(comment);
    }

    @Override
    public CommentEntity updateComment(CommentEntity comment) throws InvalidCommentException {
        if (!commentRepository.existsById(comment.getId())) {
            throw new CommentNotFoundException("Comment not found with ID: " + comment.getId());
        }
        validateComment(comment);
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long commentId) {
        if (!commentRepository .existsById(commentId)) {
            throw new CommentNotFoundException("Comment not found with ID: " + commentId);
        }
        commentRepository.deleteById(commentId);
    }

    @Override
    public CommentEntity getCommentById(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentNotFoundException("Comment not found with ID: " + commentId));
    }

    @Override
    public List<CommentEntity> getAllComments() {
        return commentRepository.findAll();
    }

    private void validateComment(CommentEntity comment) throws InvalidCommentException {
        if (comment.getDocument() == null || comment.getDocument().isEmpty()) {
            throw new InvalidCommentException("Comment text cannot be empty.");
        }
        if (comment.getUser() == null || comment.getUser().isEmpty()) {
            throw new InvalidCommentException("Comment author cannot be empty.");
        }
    }
}