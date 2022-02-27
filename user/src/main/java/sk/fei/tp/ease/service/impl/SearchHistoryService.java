package sk.fei.tp.ease.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import sk.fei.tp.ease.model.SearchHistory;
import sk.fei.tp.ease.repository.SearchHistoryRepository;
import sk.fei.tp.ease.service.ISearchHistoryService;
import sk.fei.tp.ease.util.UserUtils;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class SearchHistoryService implements ISearchHistoryService {

    private final SearchHistoryRepository searchHistoryRepository;

    @Override
    public void createHistoryEntry(String query) {
        SearchHistory searchHistory = new SearchHistory();
        searchHistory.setTime(LocalDateTime.now());
        searchHistory.setSearchedExpression(query);
        searchHistory.setUser(UserUtils.getCurrentUser());
        searchHistoryRepository.save(searchHistory);
    }

}
