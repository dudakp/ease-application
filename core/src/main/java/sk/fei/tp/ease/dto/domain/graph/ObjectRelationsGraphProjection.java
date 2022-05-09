package sk.fei.tp.ease.dto.domain.graph;

import lombok.Data;
import sk.fei.tp.ease.model.EObject;
import sk.fei.tp.ease.model.enums.ConnectorType;
import sk.fei.tp.ease.model.enums.ObjectType;

@Data
public class ObjectRelationsGraphProjection {
    private final Long startNodeId;
    private final String startNode;

    private final Long endNodeId;
    private final String endNode;

    private final ConnectorType edgeType;
    private final String stereotype;

    private final String startNodeColor;
    private final String endNodeColor;

    public ObjectRelationsGraphProjection(Long startNodeId, String startNode, Long endNodeId, String endNode, ConnectorType edgeType, String stereotype, EObject start, EObject end) {
        this.startNodeId = startNodeId;
        this.startNode = startNode;
        this.endNodeId = endNodeId;
        this.endNode = endNode;
        this.edgeType = edgeType;
        this.stereotype = stereotype;

        this.startNodeColor = generateColor(start.getType());
        this.endNodeColor = generateColor(end.getType());
    }

    private static String generateColor(ObjectType ot) {
        switch (ot) {
            case Port:
                return "#498559";
            case Text:
                return "#6babb3";
            case Class:
                return "#7b6bb3";
            case Package:
                return "#b3ab6b";
            case Artifact:
                return "#b3756b";
            case Boundary:
                return "#a66bb3";
            case Component:
                return "#80e810";
            default:
                return "#000000";
        }
    }
}
