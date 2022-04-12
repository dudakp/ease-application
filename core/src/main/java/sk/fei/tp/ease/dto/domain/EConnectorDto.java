package sk.fei.tp.ease.dto.domain;

import lombok.Data;
import sk.fei.tp.ease.model.EObject;
import sk.fei.tp.ease.model.enums.ConnectorType;

@Data
public class EConnectorDto {

    private Integer connectorId;
    private String name;
    private ConnectorType connectorType;
    private EObject startObject;
    private EObject endObject;
    private Integer diagramId;

}
