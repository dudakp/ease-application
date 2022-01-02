package sk.fei.tp.ease.dto.domain;

import lombok.Data;
import sk.fei.tp.ease.model.enums.ObjectType;

import java.util.Objects;

@Data
public final class EObjectDto {
    private Long id;
    private ObjectType type;
    private String name;
    private String alias;
    private String author;
    private Integer version;
    private EPackageDto ePackage;

}
