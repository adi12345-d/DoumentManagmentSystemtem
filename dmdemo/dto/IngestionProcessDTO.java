package com.document.dmdemo.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class IngestionProcessDTO {
    private Long id;
    private String status;
    private LocalDateTime startedAt;
    private LocalDateTime completedAt;
}