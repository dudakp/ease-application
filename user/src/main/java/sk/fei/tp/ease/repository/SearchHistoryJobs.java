package sk.fei.tp.ease.repository;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;

@Component
public class SearchHistoryJobs {
    private final SearchHistoryRepository searchHistoryRepository;

    public SearchHistoryJobs(SearchHistoryRepository searchHistoryRepository) {
        this.searchHistoryRepository = searchHistoryRepository;
    }

    @Scheduled(cron = "0 0 0 ? * 1/7 *") // every 7 days, starting each Sunday
    public void removeOldSearchHistory() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime olderThanWeek = now.minusDays(7);

        searchHistoryRepository.removeOldSearchHistory(olderThanWeek);
    }
}