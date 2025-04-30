package com.document.dmdemo.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SessionDTO {
    private Long id;
    private Long userId; // Reference to the associated user
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
}