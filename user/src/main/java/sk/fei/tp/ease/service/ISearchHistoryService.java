package sk.fei.tp.ease.service;

import sk.fei.tp.ease.dto.SearchHistoryDto;

import java.util.List;

public interface ISearchHistoryService {
    void createHistoryEntry(String query);
    List<SearchHistoryDto> searchHistory(String user);
}
