package sk.fei.tp.ease.dto.domain;

import lombok.Data;
import sk.fei.tp.ease.model.enums.ObjectType;

import java.util.List;
import java.util.Set;

@Data
public class EObjectDto {
    private Long id;
    private ObjectType type;
    private String name;
    private String alias;
    private String author;
    private Integer version;
    private Set<Long> diagrams;
    private EObjectWithPackageDto parent;
    private String note;
    private List<Object> objectProperties;
}
