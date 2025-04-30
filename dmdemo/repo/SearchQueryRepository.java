package com.document.dmdemo.repo;

import com.document.dmdemo.model.SearchQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchQueryRepository extends JpaRepository<SearchQueryEntity, Long> {
    List<SearchQueryEntity> findByUserId(Long userId);
}