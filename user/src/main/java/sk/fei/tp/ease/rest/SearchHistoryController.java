package sk.fei.tp.ease.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sk.fei.tp.ease.dto.SearchHistoryDto;
import sk.fei.tp.ease.dto.common.PagedResult;
import sk.fei.tp.ease.service.ISearchHistoryService;

@RestController
@RequestMapping("/user/searchHistory")
@RequiredArgsConstructor
public class SearchHistoryController {
    private final ISearchHistoryService searchHistoryService;

    @PostMapping
    public void createSearchHistoryEntry(@RequestParam String query){
        searchHistoryService.createHistoryEntry(query);
    }

    @GetMapping
    public PagedResult<SearchHistoryDto> searchHistory(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer pageSize){
        return searchHistoryService.searchHistory(page, pageSize);
    }
}

