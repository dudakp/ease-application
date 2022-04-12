package sk.fei.tp.ease.dto.domain.graph;

import lombok.Data;
import sk.fei.tp.ease.dto.domain.EDiagramDto;
import sk.fei.tp.ease.dto.domain.EObjectPropertyDto;

import java.util.List;

@Data
public class ObjectUsageGraphDto {

    private final Long objectId;
    private final String name;
    private final List<EDiagramDto> usedInDiagrams;
    private final List<EObjectPropertyDto> objectProperties;

}
