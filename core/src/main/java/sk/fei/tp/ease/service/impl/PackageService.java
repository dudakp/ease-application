package sk.fei.tp.ease.service.impl;

import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import sk.fei.tp.ease.dto.domain.EPackageDto;
import sk.fei.tp.ease.repository.EPackageRepository;
import sk.fei.tp.ease.service.IPackageService;

@Service
@RequiredArgsConstructor
public class PackageService implements IPackageService {

    private final EPackageRepository packageRepository;
    private final DozerBeanMapper mapper;

    @Override
    public EPackageDto findById(Long id) {
        return packageRepository.findById(id)
                .map(p -> mapper.map(p, EPackageDto.class))
                .orElseThrow(() -> new ObjectNotFoundException(id, EPackageDto.class.getSimpleName()));
    }
}
