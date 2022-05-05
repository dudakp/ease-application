package sk.fei.tp.ease.service;

import sk.fei.tp.ease.dto.domain.graph.ObjectRelationsGraphProjection;
import sk.fei.tp.ease.dto.domain.graph.ObjectUsageGraphDto;
import sk.fei.tp.ease.dto.domain.search.ConnectorFilterDataDto;
import sk.fei.tp.ease.model.enums.ConnectorType;

import java.util.List;
import java.util.Set;

public interface IObjectGraphService {

    ObjectUsageGraphDto findObjectUsage(Long objectId);

    List<ObjectRelationsGraphProjection> findObjectOutgoingRelationsThroughPorts(Long startObjectId);

    Set<ObjectRelationsGraphProjection> findCompleteGraph(Integer depth, ConnectorType connectorType);

    List<ConnectorFilterDataDto> filterContents();
}
