package sk.fei.tp.ease.service;

import sk.fei.tp.ease.dto.domain.EObjectDto;
import sk.fei.tp.ease.model.EObject;

public interface IObjectService {
    EObjectDto find(Long id);
}
