package sk.fei.tp.ease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sk.fei.tp.ease.model.EObject;
import sk.fei.tp.ease.model.enums.ObjectType;

import java.util.List;
import java.util.Optional;

@Repository
public interface EObjectRepository extends JpaRepository<EObject, Long> {
    @Query("select distinct o.type from EObject o")
    List<ObjectType> findAllObjectTypes();

    @Query("select o from EObject o where o.name = :name and o.type = 'Component' ")
    List<EObject> findComponentByName(@Param("name") String name);

    @Query("select o.name from EObject o where o.id = :id ")
    Optional<String> getName(@Param("id") Long id);
}
