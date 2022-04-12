package sk.fei.tp.ease.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sk.fei.tp.ease.dto.domain.EDiagramDto;
import sk.fei.tp.ease.dto.domain.EObjectDto;
import sk.fei.tp.ease.service.IDiagramService;

import java.util.List;

@RestController
@RequestMapping("/core/diagram")
@RequiredArgsConstructor
public class DiagramController {

    private final IDiagramService diagramService;

    @GetMapping("/{id}")
    public EDiagramDto getDiagram(@PathVariable Long id) {
        return this.diagramService.find(id);
    }

}
