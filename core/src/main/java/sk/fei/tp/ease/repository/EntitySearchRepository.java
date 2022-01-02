package sk.fei.tp.ease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sk.fei.tp.ease.dto.domain.search.GeneralSearchResultDto;
import sk.fei.tp.ease.model.EntitySearchView;

import java.util.List;

@Repository
public interface EntitySearchRepository extends JpaRepository<EntitySearchView, Long> {

    List<EntitySearchView> findByNameContainingIgnoreCase(@Param("name") String name);

}
