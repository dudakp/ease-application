package sk.fei.tp.ease.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import sk.fei.tp.ease.model.SearchHistory;

public interface SearchHistoryRepository extends PagingAndSortingRepository <SearchHistory, Long> {

    @Query("from SearchHistory sh where sh.user = :user order by sh.time desc")
    Page<SearchHistory> findByUser(@Param("user") String user, Pageable pageable);
}
