package sk.fei.tp.ease.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sk.fei.tp.ease.dto.SearchHistoryDto;
import sk.fei.tp.ease.model.SearchHistory;
import sk.fei.tp.ease.repository.SearchHistoryRepository;
import sk.fei.tp.ease.service.ISearchHistoryService;

import java.time.LocalDateTime;
import java.util.List;

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

    @Override
    public List<SearchHistoryDto> searchHistory(String user){
        return searchHistoryRepository.findByUser(user);
    }
}
