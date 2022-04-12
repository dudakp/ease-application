package sk.fei.tp.ease.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fei.tp.ease.dto.domain.EObjectDto;
import sk.fei.tp.ease.dto.domain.graph.ObjectUsageGraphDto;
import sk.fei.tp.ease.service.IDiagramService;
import sk.fei.tp.ease.service.IObjectGraphService;

import java.util.List;

@RestController
@RequestMapping("/graph/usage")
@RequiredArgsConstructor
public class UsageGraphController {

    private final IObjectGraphService graphService;
    private final IDiagramService diagramService;

    @GetMapping("/object/{id}")
    public ObjectUsageGraphDto getObjectUsages(@PathVariable Long id) {
        return graphService.findObjectUsage(id);
    }

    @GetMapping("/diagram/containingObjects/{id}")
    public List<EObjectDto> getDiagramContainingObjects(@PathVariable Long id) {
        return diagramService.getAllContainingObjects(id);
    }

}
