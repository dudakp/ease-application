package sk.fei.tp.ease.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import java.time.LocalDateTime;
import sk.fei.tp.ease.model.SearchHistory;

public interface SearchHistoryRepository extends PagingAndSortingRepository <SearchHistory, Long> {

    @Query("from SearchHistory sh where sh.user = :user")
    Page<SearchHistory> findByUser(@Param("user") String user, Pageable pageable);


    @Modifying
    @Query("delete from SearchHistory sh where time < :time")
    void removeOldSearchHistory(@Param("time") LocalDateTime time);
}
