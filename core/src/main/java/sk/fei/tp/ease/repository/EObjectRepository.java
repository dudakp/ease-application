package sk.fei.tp.ease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sk.fei.tp.ease.model.EObject;
import sk.fei.tp.ease.model.enums.ObjectType;

import java.util.List;

@Repository
public interface EObjectRepository extends JpaRepository<EObject, Long> {
    @Query("select distinct o.type from EObject o")
    List<ObjectType> findAllObjectTypes();
}
