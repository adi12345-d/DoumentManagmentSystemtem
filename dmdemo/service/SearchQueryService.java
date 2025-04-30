package com.document.dmdemo.service;

import com.document.dmdemo.model.SearchQueryEntity;

import java.util.List;

public interface SearchQueryService {
    SearchQueryEntity logSearchQuery(SearchQueryEntity searchQuery);
    List<SearchQueryEntity> getSearchQueriesByUserId(Long userId);
}