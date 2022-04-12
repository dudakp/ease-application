package sk.fei.tp.ease.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sk.fei.tp.ease.dto.domain.graph.ObjectRelationsGraphProjection;
import sk.fei.tp.ease.model.enums.ConnectorType;
import sk.fei.tp.ease.service.IObjectGraphService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/graph/relation")
@RequiredArgsConstructor
public class RelationGraphController {
    private final IObjectGraphService graphService;

    @GetMapping("/highLevelObjectOutgoingRelations/{id}")
    public List<ObjectRelationsGraphProjection> getObjectOutgoingRelations(@PathVariable Long id) {
        return graphService.findObjectOutgoingRelationsThroughPorts(id);
    }

    @GetMapping("/highLevelCompleteGraph")
    public Set<ObjectRelationsGraphProjection> getCompleteGraph(@RequestParam(required = false) Integer depth,
                                                                @RequestParam(required = false) ConnectorType connectorType) {
        return graphService.findCompleteGraph(depth, connectorType);
    }

}
