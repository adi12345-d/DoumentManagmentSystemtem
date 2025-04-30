package com.document.dmdemo.dto;

import lombok.Data;

@Data
public class MetadataDTO {
    private Long id;
    private String keyword;
    private Long documentId; // Reference to the associated document
}