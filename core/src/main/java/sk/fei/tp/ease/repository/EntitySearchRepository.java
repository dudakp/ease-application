package sk.fei.tp.ease.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sk.fei.tp.ease.dto.domain.search.GeneralSearchResultDto;
import sk.fei.tp.ease.model.EntitySearchView;

import java.util.List;

@Repository
public interface EntitySearchRepository extends PagingAndSortingRepository<EntitySearchView, Long> {

    Page<EntitySearchView> findByNameContainingIgnoreCase(@Param("name") String name, Pageable pageable);

}
