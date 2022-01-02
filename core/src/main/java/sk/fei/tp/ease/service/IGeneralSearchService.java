package sk.fei.tp.ease.service;

import sk.fei.tp.ease.dto.domain.search.GeneralSearchResultDto;
import sk.fei.tp.ease.dto.request.SearchRequestDto;

import java.util.List;

public interface IGeneralSearchService {
    List<GeneralSearchResultDto> searchEntities(SearchRequestDto searchRequest);
}
