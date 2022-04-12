package sk.fei.tp.ease.service.impl;

import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import sk.fei.tp.ease.dto.domain.EObjectWithPackageDto;
import sk.fei.tp.ease.model.EObject;
import sk.fei.tp.ease.repository.EObjectRepository;
import sk.fei.tp.ease.service.IObjectService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ObjectService implements IObjectService {

    private final EObjectRepository objectRepository;
    private final DozerBeanMapper mapper;

    @Override
    public EObjectWithPackageDto find(Long id) {
        return objectRepository.findById(id)
                .map(eObject -> mapper.map(eObject, EObjectWithPackageDto.class))
                .orElseThrow(() -> new ObjectNotFoundException(id, EObjectWithPackageDto.class.getSimpleName()));
    }

    @Override
    public List<EObjectWithPackageDto> findByIdWithDuplicates(Long id) {
        return objectRepository.getName(id)
                .map(this::findByName)
                .map(objects -> objects.stream()
                        .map(obj -> mapper.map(obj, EObjectWithPackageDto.class))
                        .collect(Collectors.toList()))
                .orElseThrow();
    }

    private List<EObject> findByName(String name) {
        return objectRepository.findComponentByName(name);
    }
}
