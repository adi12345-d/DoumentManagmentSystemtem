package com.document.dmdemo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "search_queries")
public class SearchQueryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String query;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

}
