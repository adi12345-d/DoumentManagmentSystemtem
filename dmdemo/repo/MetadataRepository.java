package com.document.dmdemo.repo;

import com.document.dmdemo.model.MetadataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MetadataRepository extends JpaRepository<MetadataEntity, Long> {
    List<MetadataEntity> findByKeyword(String keyword);
}