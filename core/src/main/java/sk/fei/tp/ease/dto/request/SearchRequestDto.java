package sk.fei.tp.ease.dto.request;

import lombok.Data;
import org.springframework.lang.Nullable;
import sk.fei.tp.ease.dto.common.PagingFilter;
import sk.fei.tp.ease.dto.domain.search.EntityType;
import sk.fei.tp.ease.model.enums.DiagramType;
import sk.fei.tp.ease.model.enums.ObjectType;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public final class SearchRequestDto {

    @NotNull
    private String name;
    @Nullable
    private EntityType entityTypeFilter;
    @Nullable
    private ObjectType objectDetailedTypeFilter;
    @Nullable
    private DiagramType diagramDetailedTypeFilter;

    @Valid
    private PagingFilter pagingFilter;

}
