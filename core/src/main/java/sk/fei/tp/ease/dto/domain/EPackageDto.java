package sk.fei.tp.ease.dto.domain;

import lombok.Data;

import java.util.Objects;

@Data
public final class EPackageDto {
    private Long id;
    private String name;
    private EPackageDto parent;
    private Integer version;
}
