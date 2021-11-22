package sk.fei.tp.ease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sk.fei.tp.ease.model.EDiagram;
import sk.fei.tp.ease.model.EObject;

import java.util.List;

@Repository
public interface EDiagramRepository extends JpaRepository<EDiagram, Long> {

    @Query("select d.objects from EDiagram d where d.id = :id")
    List<EObject> findAllContainingObjects(@Param("id") Long id);

}
