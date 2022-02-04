package sk.fei.tp.ease.service;

import sk.fei.tp.ease.dto.domain.EDiagramDto;
import sk.fei.tp.ease.dto.domain.EObjectDto;
import sk.fei.tp.ease.dto.domain.EObjectWithPackageDto;

import java.util.List;

public interface IDiagramService {
    EDiagramDto find(Long id);

    List<EObjectDto> getAllContainingObjects(Long id);
}
