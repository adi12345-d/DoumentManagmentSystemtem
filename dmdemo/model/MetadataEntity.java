package com.document.dmdemo.model;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "metadata")
public class MetadataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String keyword;

    @ManyToOne
    @JoinColumn(name = "document_id", nullable = false)
    private DocumentEntity document;

    // Getters and Setters
}