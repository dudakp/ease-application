package sk.fei.tp.ease.service.impl;

import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import sk.fei.tp.ease.dto.domain.EDiagramDto;
import sk.fei.tp.ease.dto.domain.EObjectDto;
import sk.fei.tp.ease.repository.EDiagramRepository;
import sk.fei.tp.ease.service.IDiagramService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DiagramService implements IDiagramService {

    private final EDiagramRepository diagramRepository;
    private final DozerBeanMapper mapper;

    @Override
    public EDiagramDto find(Long id) {
        return this.diagramRepository.findById(id)
                .map(eDiagram -> mapper.map(eDiagram, EDiagramDto.class))
                .orElseThrow(() -> new ObjectNotFoundException(id, EDiagramDto.class.getSimpleName()));
    }

    @Override
    public List<EObjectDto> getAllContainingObjects(Long id) {
        return diagramRepository.findAllContainingObjects(id).stream()
                .map(d -> mapper.map(d, EObjectDto.class))
                .collect(Collectors.toList());
    }
}
