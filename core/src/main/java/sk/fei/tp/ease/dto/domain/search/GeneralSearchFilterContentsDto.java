package sk.fei.tp.ease.dto.domain.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import sk.fei.tp.ease.model.enums.DiagramType;
import sk.fei.tp.ease.model.enums.ObjectType;

import java.util.List;

@Data
@AllArgsConstructor
public class GeneralSearchFilterContentsDto {
    private final List<DiagramType> diagramDetailedTypes;
    private final List<ObjectType> objectDetailedTypes;
}
