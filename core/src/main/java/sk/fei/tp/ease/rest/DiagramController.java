package sk.fei.tp.ease.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sk.fei.tp.ease.dto.domain.EObjectDto;
import sk.fei.tp.ease.service.IDiagramService;

import java.util.List;

@RestController
@RequestMapping("/core/diagram")
@RequiredArgsConstructor
public class DiagramController {

    private final IDiagramService diagramService;

    @GetMapping("/getAllContainingObjects")
    public List<EObjectDto> getAllContainingObjects(@RequestParam Long id) {
        return diagramService.getAllContainingObjects(id);
    }
}
