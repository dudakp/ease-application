package sk.fei.tp.ease.dto.domain;

import java.util.List;

public record EDiagramDto(Long id,
                          EPackageDto tPackage,
                          List<EObjectDto> objects,
                          String name,
                          String author,
                          Integer version) {
}
