package sk.fei.tp.ease.service;

import sk.fei.tp.ease.dto.domain.EObjectWithPackageDto;

import java.util.List;

public interface IObjectService {
    EObjectWithPackageDto find(Long id);

    List<EObjectWithPackageDto> findByIdWithDuplicates(Long id);
}
