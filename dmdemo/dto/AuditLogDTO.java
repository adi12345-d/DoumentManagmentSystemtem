package com.document.dmdemo.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AuditLogDTO {
    private Long id;
    private Long documentId; // Reference to the associated document
    private String action;
    private LocalDateTime timestamp;
    private Long userId; // Reference to the user who performed the action
}