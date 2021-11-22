package sk.fei.tp.ease.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sk.fei.tp.ease.dto.domain.EObjectDto;
import sk.fei.tp.ease.repository.EDiagramRepository;
import sk.fei.tp.ease.service.IDiagramService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiagramService implements IDiagramService {

    private final EDiagramRepository diagramRepository;

    @Override
    public List<EObjectDto> getAllContainingObjects(Long id) {
        return diagramRepository.findAllContainingObjects(id).stream()
                .map(d -> new EObjectDto(d.getId(), d.getType(), d.getName(), d.getAlias(), d.getAuthor(), d.getVersion()))
                .toList();
    }
}
