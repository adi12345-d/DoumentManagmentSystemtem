package com.document.dmdemo.serviceImpl;

import com.document.dmdemo.exception.SearchQueryNotFoundException;
import com.document.dmdemo.model.SearchQueryEntity;
import com.document.dmdemo.repo.SearchQueryRepository;
import com.document.dmdemo.service.SearchQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class SearchQueryServiceImpl implements SearchQueryService {

    @Autowired
    private SearchQueryRepository searchQueryRepository;

    @Override
    public SearchQueryEntity saveSearchQuery(SearchQueryEntity searchQuery) {
        return searchQueryRepository.save(searchQuery);
    }

    @Override
    public void deleteSearchQuery(Long searchQueryId) {
        if (!searchQueryRepository.existsById(searchQueryId)) {
            throw new SearchQueryNotFoundException("Search query not found with ID: " + searchQueryId);
        }
        searchQueryRepository.deleteById(searchQueryId);
    }

    @Override
    public SearchQueryEntity getSearchQueryById(Long searchQueryId) {
        return searchQueryRepository.findById(searchQueryId)
                .orElseThrow(() -> new SearchQueryNotFoundException("Search query not found with ID: " + searchQueryId));
    }

    @Override
    public List<SearchQueryEntity> getAllSearchQueries() {
        return searchQueryRepository.findAll();
    }
}