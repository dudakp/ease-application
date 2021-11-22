package sk.fei.tp.ease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.fei.tp.ease.model.EntitySearchView;

@Repository
public interface EntitySearchRepository extends JpaRepository<EntitySearchView, Long> {


}
