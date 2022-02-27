package sk.fei.tp.ease.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import sk.fei.tp.ease.dto.SearchHistoryDto;
import sk.fei.tp.ease.model.SearchHistory;

import java.util.List;

public interface SearchHistoryRepository extends PagingAndSortingRepository <SearchHistory, Long> {

    @Query("from SearchHistory where user = :user")
    List<SearchHistoryDto> findByUser(@Param("user") String user);
}
