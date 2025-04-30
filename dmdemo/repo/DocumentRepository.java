package com.document.dmdemo.repo;

import com.document.dmdemo.model.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<DocumentEntity, Long> {
    List<DocumentEntity> findByTitleContainingIgnoreCase(String title);
    List<DocumentEntity> findByAuthor(String author);
}