package sk.fei.tp.ease.dto.domain.graph;

import lombok.Data;
import sk.fei.tp.ease.model.enums.ConnectorType;

@Data
public class ObjectRelationsGraphProjection {
    private final Long startNodeId;
    private final String startNode;

    private final Long endNodeId;
    private final String endNode;

    private final ConnectorType edgeType;
}
