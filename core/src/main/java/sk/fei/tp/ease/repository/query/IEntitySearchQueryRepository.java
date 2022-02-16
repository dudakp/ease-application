package sk.fei.tp.ease.repository.query;

import sk.fei.tp.ease.dto.common.PagedResult;
import sk.fei.tp.ease.dto.request.SearchRequestDto;
import sk.fei.tp.ease.model.EntitySearchView;

public interface IEntitySearchQueryRepository {
    PagedResult<EntitySearchView> find(SearchRequestDto filter);
}
