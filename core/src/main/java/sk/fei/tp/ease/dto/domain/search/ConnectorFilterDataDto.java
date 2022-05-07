package sk.fei.tp.ease.dto.domain.search;

import lombok.Data;
import sk.fei.tp.ease.model.enums.ConnectorType;

import java.util.Map;

@Data
public class ConnectorFilterDataDto {

    public ConnectorFilterDataDto(ConnectorType connectorType, String stereotype) {
        this.connectorType = Map.of(connectorType.name(), String.format("#%06X", (0xFFFFFF & connectorType.name().length() + 5000)));
        this.stereotype = Map.of(stereotype == null ? "" : stereotype, String.format("#%06X", (0xFF0000 & (stereotype == null ? 0 : stereotype.length()))));
    }

    private final Map<String, String> connectorType;
    private final Map<String, String> stereotype;

}
