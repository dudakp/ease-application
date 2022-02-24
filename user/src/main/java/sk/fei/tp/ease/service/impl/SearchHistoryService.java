package sk.fei.tp.ease.service.impl;

import sk.fei.tp.ease.model.SearchHistory;
import sk.fei.tp.ease.repository.SearchHistoryRepository;
import sk.fei.tp.ease.service.ISearchHistoryService;

import java.time.LocalTime;

public class SearchHistoryService implements ISearchHistoryService {

    private final SearchHistoryRepository searchHistoryRepository;

    public SearchHistoryService(SearchHistoryRepository searchHistoryRepository) {
        this.searchHistoryRepository = searchHistoryRepository;
    }

    @Override
    public void createHistoryEntry(String query){
        SearchHistory searchHistory = new SearchHistory();
        searchHistory.setTime(LocalTime.now());
        searchHistory.setSearchedExpression(query);
        searchHistory.setUser("");
        searchHistoryRepository.save(searchHistory);
    }

}
