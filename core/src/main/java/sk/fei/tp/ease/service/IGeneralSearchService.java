package sk.fei.tp.ease.service;

import sk.fei.tp.ease.dto.common.PagedResult;
import sk.fei.tp.ease.dto.domain.search.GeneralSearchFilterContentsDto;
import sk.fei.tp.ease.dto.domain.search.GeneralSearchResultDto;
import sk.fei.tp.ease.dto.request.SearchRequestDto;

import java.util.List;

public interface IGeneralSearchService {
    PagedResult<GeneralSearchResultDto> searchEntities(SearchRequestDto searchRequest);

    GeneralSearchFilterContentsDto getFilterContents();
}
