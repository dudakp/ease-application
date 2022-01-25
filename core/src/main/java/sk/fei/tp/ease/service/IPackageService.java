package sk.fei.tp.ease.service;

import sk.fei.tp.ease.dto.domain.EPackageDto;

public interface IPackageService {
    EPackageDto findById(Long id);
}
