package sk.fei.tp.ease.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sk.fei.tp.ease.dto.SearchHistoryDto;
import sk.fei.tp.ease.dto.common.PagedResult;
import sk.fei.tp.ease.service.ISearchHistoryService;

import java.util.List;

@RestController
@RequestMapping("/user/searchHistory")
@RequiredArgsConstructor
public class SearchHistoryController {
    private final ISearchHistoryService searchHistoryService;

    @PostMapping
    public void createSearchHistoryEntry(@RequestParam String query){
        searchHistoryService.createHistoryEntry(query);
    }

    @PutMapping(path = "/general")
    public PagedResult<SearchHistoryDto> searchHistory(@RequestParam String user){
        return searchHistoryService.searchHistory(user);
    }
}

