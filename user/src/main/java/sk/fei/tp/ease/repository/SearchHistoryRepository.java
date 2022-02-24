package sk.fei.tp.ease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.fei.tp.ease.model.SearchHistory;

public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Long> {
}
