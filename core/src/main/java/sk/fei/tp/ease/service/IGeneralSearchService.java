package sk.fei.tp.ease.service;

import sk.fei.tp.ease.dto.domain.search.GeneralSearchResultDto;

import java.util.List;

public interface IGeneralSearchService {
    List<GeneralSearchResultDto> searchEntities(GeneralSearchResultDto searchRequest);
}
