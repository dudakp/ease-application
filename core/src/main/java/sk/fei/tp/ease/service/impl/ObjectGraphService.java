package sk.fei.tp.ease.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sk.fei.tp.ease.dto.domain.EDiagramDto;
import sk.fei.tp.ease.dto.domain.EObjectWithPackageDto;
import sk.fei.tp.ease.dto.domain.graph.ObjectRelationsGraphProjection;
import sk.fei.tp.ease.dto.domain.graph.ObjectUsageGraphDto;
import sk.fei.tp.ease.dto.domain.search.ConnectorFilterDataDto;
import sk.fei.tp.ease.model.enums.ConnectorType;
import sk.fei.tp.ease.repository.EConnectorRepository;
import sk.fei.tp.ease.service.IDiagramService;
import sk.fei.tp.ease.service.IObjectGraphService;
import sk.fei.tp.ease.service.IObjectService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ObjectGraphService implements IObjectGraphService {

    private final IObjectService objectService;
    private final IDiagramService diagramService;
    private final EConnectorRepository connectorRepository;

    @Override
    public ObjectUsageGraphDto findObjectUsage(Long objectId) {
        EObjectWithPackageDto object = objectService.find(objectId);
        List<EDiagramDto> diagrams = diagramService.find(object.getDiagrams());
        return new ObjectUsageGraphDto(object.getId(), object.getName(), diagrams, object.getObjectProperties());
    }


    @Override
    public List<ObjectRelationsGraphProjection> findObjectOutgoingRelationsThroughPorts(Long startObjectId) {
        return objectService.findByIdWithDuplicates(startObjectId).stream()
                .flatMap(obj -> connectorRepository.findObjectGraphOutgoing(obj.getId()).stream())
                .collect(Collectors.toList());
    }

    @Override
    public Set<ObjectRelationsGraphProjection> findCompleteGraph(Integer depth, ConnectorType connectorType) {
        return Stream.concat(
                connectorRepository.findCompleteGraph(connectorType).stream(),
                connectorRepository.findCompleteGraphWithPortConnections(connectorType).stream()
        ).collect(Collectors.toSet());
    }

    @Override
    public List<ConnectorFilterDataDto> filterContents() {
        return connectorRepository.findAllConnectorTypes();
    }

}
