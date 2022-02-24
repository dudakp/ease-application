package sk.fei.tp.ease.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
}
