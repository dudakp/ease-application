package sk.fei.tp.ease.dto.common;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class PagedResult<T> {
    private final List<T> results;
    private final long numAllResults;
    private final long numPages;

    private final int pageSize;
    private final int pageIndex;

    public PagedResult(List<T> results, PagedResult<?> other) {
        this.results = results;
        this.numAllResults = other.getNumAllResults();
        this.numPages = other.getNumPages();
        this.pageSize = other.getPageSize();
        this.pageIndex = other.pageIndex;
    }
}
