package com.document.dmdemo.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CommentDTO {
    private Long id;
    private String content;
    private Long documentId; // Reference to the associated document
    private Long userId; // Reference to the user who made the comment
    private LocalDateTime createdAt;
}