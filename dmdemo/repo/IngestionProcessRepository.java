package com.document.dmdemo.repo;

import com.document.dmdemo.model.IngestionProcessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngestionProcessRepository extends JpaRepository<IngestionProcessEntity, Long> {
    List<IngestionProcessEntity> findByStatus(String status);
}