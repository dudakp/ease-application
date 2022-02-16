package sk.fei.tp.ease.repository.impl;

import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import sk.fei.tp.ease.dto.common.PagedResult;
import sk.fei.tp.ease.dto.common.PagingFilter;
import sk.fei.tp.ease.dto.request.GeneralSearchOrderKey;
import sk.fei.tp.ease.dto.request.SearchRequestDto;
import sk.fei.tp.ease.model.EntitySearchView;
import sk.fei.tp.ease.model.QEntitySearchView;
import sk.fei.tp.ease.repository.query.IEntitySearchQueryRepository;
import sk.fei.tp.ease.utils.PagingUtils;


@Repository
public class EntitySearchQueryRepository extends QuerydslRepositorySupport implements IEntitySearchQueryRepository {

    public EntitySearchQueryRepository() {
        super(EntitySearchView.class);
    }

    @Override
    public PagedResult<EntitySearchView> find(SearchRequestDto searchFilter) {
        QEntitySearchView searchView = QEntitySearchView.entitySearchView;

        JPQLQuery<EntitySearchView> query = from(searchView)
                .where(searchView.name.containsIgnoreCase(searchFilter.getName()));

        PagingFilter pagingFilter = searchFilter.getPagingFilter();
        if (searchFilter.getEntityTypeFilter() != null) {
            query.where(searchView.type.eq(searchFilter.getEntityTypeFilter()));
        }

        if (searchFilter.getObjectDetailedTypeFilter() != null) {
            query.where(searchView.detailedType.eq(searchFilter.getObjectDetailedTypeFilter().name()));
        }

        if (searchFilter.getDiagramDetailedTypeFilter() != null) {
            query.where(searchView.detailedType.eq(searchFilter.getDiagramDetailedTypeFilter().name()));
        }


        if (pagingFilter.getOrderKey() != null) {
            StringPath orderKey = resolveOrderKeyFromString(pagingFilter.getOrderKey(), searchView);
            query.orderBy(pagingFilter.isDescending()
                    ? orderKey.desc()
                    : orderKey.asc()
            );
        }

        return PagingUtils.getPagedResult(pagingFilter, query);
    }

    private StringPath resolveOrderKeyFromString(GeneralSearchOrderKey orderKey, QEntitySearchView qEntity) {
        switch (orderKey) {
            case name:
                return qEntity.name;
            default:
                throw new IllegalArgumentException("Unknown order key!");
        }
    }
}
