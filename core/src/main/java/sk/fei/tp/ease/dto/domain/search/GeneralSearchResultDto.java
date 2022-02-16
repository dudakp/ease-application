package sk.fei.tp.ease.dto.domain.search;

import lombok.Data;


@Data
public final class GeneralSearchResultDto {

    private Long id;
    private EntityType type;
    private String name;
    private Long packageId;
    private String detailedType;

}
