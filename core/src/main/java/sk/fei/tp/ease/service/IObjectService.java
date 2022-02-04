package sk.fei.tp.ease.service;

import sk.fei.tp.ease.dto.domain.EObjectWithPackageDto;

public interface IObjectService {
    EObjectWithPackageDto find(Long id);
}
