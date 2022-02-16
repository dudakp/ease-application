package sk.fei.tp.ease.utils;

import com.querydsl.jpa.JPQLQuery;
import sk.fei.tp.ease.dto.common.PagedResult;
import sk.fei.tp.ease.dto.common.PagingFilter;

import java.util.List;

public class PagingUtils {

    public static <T> PagedResult<T> getPagedResult(PagingFilter pagingFilter, JPQLQuery<T> query) {
        long page = (long) pagingFilter.getPage() * pagingFilter.getPageSize();
        int pageSize = pagingFilter.getPageSize();

        List<T> result = query.limit(pageSize)
                .offset(page)
                .fetch();

        long numAllResults = query.fetchCount();
        return createPagedResult(
                result,
                numAllResults,
                numAllResults / pageSize,
                pagingFilter
        );
    }

    public static <T> PagedResult<T> createPagedResult(List<T> data, long numAllResults, long numPages, PagingFilter pagingFilter) {
        return new PagedResult<>(data, numAllResults, numPages, pagingFilter.getPageSize(), pagingFilter.getPage());
    }

}
