package sk.fei.tp.ease.service.impl;

import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import sk.fei.tp.ease.dto.domain.EObjectDto;
import sk.fei.tp.ease.repository.EObjectRepository;
import sk.fei.tp.ease.service.IObjectService;

@Service
@RequiredArgsConstructor
public class ObjectService implements IObjectService {

    private final EObjectRepository objectRepository;
    private final DozerBeanMapper mapper;

    @Override
    public EObjectDto find(Long id) {
        return objectRepository.findById(id)
                .map(eObject -> mapper.map(eObject, EObjectDto.class))
                .orElseThrow(() -> new ObjectNotFoundException(id, EObjectDto.class.getSimpleName()));
    }
}
