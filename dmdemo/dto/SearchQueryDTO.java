package com.document.dmdemo.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SearchQueryDTO {
    private Long id;
    private String query;
    private LocalDateTime timestamp;
    private Long userId; // Reference to the user who made the query
}