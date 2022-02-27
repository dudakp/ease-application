package sk.fei.tp.ease.service.impl;

import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sk.fei.tp.ease.dto.SearchHistoryDto;
import sk.fei.tp.ease.dto.common.PagedResult;
import sk.fei.tp.ease.model.SearchHistory;
import sk.fei.tp.ease.repository.SearchHistoryRepository;
import sk.fei.tp.ease.service.ISearchHistoryService;
import sk.fei.tp.ease.util.UserUtils;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchHistoryService implements ISearchHistoryService {

    private final SearchHistoryRepository searchHistoryRepository;
    private final DozerBeanMapper mapper;

    @Override
    public void createHistoryEntry(String query) {
        SearchHistory searchHistory = new SearchHistory();
        searchHistory.setTime(LocalDateTime.now());
        searchHistory.setSearchedExpression(query);
        searchHistory.setUser(UserUtils.getCurrentUser());
        searchHistoryRepository.save(searchHistory);
    }

    @Override
    public PagedResult<SearchHistoryDto> searchHistory(String user) {
        Page<SearchHistory> byUser = searchHistoryRepository.findByUser(user, PageRequest.of(0, 10));

        return new PagedResult<>(byUser.getContent().stream()
                .map(e -> mapper.map(e, SearchHistoryDto.class))
                .collect(Collectors.toList()),
                byUser.getTotalElements(),
                byUser.getTotalPages(),
                byUser.getPageable().getPageSize(),
                byUser.getPageable().getPageNumber()
        );
    }
}
