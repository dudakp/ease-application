package sk.fei.tp.ease.model;

import lombok.Getter;
import org.springframework.data.annotation.Immutable;
import sk.fei.tp.ease.dto.domain.search.EntityType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entity_search")
@Immutable
@Getter
public class EntitySearchView {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    EntityType type;

    @Column(name = "package")
    Long packageId;

}
