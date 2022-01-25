package sk.fei.tp.ease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.fei.tp.ease.model.EPackage;

@Repository
public interface EPackageRepository extends JpaRepository<EPackage, Long> {
}
