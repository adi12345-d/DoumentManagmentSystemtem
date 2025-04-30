package com.document.dmdemo.repo;

import com.document.dmdemo.model.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Long> {
    TagEntity findByName(String name);
}