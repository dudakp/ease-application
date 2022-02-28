package sk.fei.tp.ease.service;

import sk.fei.tp.ease.dto.SearchHistoryDto;
import sk.fei.tp.ease.dto.common.PagedResult;

import java.util.List;

public interface ISearchHistoryService {
    void createHistoryEntry(String query);
    PagedResult<SearchHistoryDto> searchHistory(Integer page, Integer pageSize);
}
