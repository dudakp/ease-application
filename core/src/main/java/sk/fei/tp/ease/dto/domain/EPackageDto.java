package sk.fei.tp.ease.dto.domain;

public record EPackageDto(Long id,
                          String name,
                          EPackageDto parent,
                          Integer version) {
}
