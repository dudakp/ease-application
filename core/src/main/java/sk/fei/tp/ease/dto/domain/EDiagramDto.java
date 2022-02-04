package sk.fei.tp.ease.dto.domain;

import lombok.Data;

import java.util.List;

@Data
public final class EDiagramDto {
    private Long id;
    private EPackageDto tPackage;
    private String name;
    private String author;
    private Integer version;

}
