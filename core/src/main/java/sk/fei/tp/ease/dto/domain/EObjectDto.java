package sk.fei.tp.ease.dto.domain;

import sk.fei.tp.ease.model.enums.ObjectType;

public record EObjectDto(
        Long id,
        ObjectType type,
        String name,
        String alias,
        String author,
        Integer version
) {
}
