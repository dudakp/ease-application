package sk.fei.tp.ease.service;

import sk.fei.tp.ease.dto.domain.EObjectDto;

import java.util.List;

public interface IDiagramService {
    List<EObjectDto> getAllContainingObjects(Long id);
}
