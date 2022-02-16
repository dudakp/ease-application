package sk.fei.tp.ease.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sk.fei.tp.ease.dto.common.PagedResult;
import sk.fei.tp.ease.dto.domain.search.GeneralSearchFilterContentsDto;
import sk.fei.tp.ease.dto.domain.search.GeneralSearchResultDto;
import sk.fei.tp.ease.dto.request.SearchRequestDto;
import sk.fei.tp.ease.repository.EDiagramRepository;
import sk.fei.tp.ease.repository.EObjectRepository;
import sk.fei.tp.ease.repository.query.IEntitySearchQueryRepository;
import sk.fei.tp.ease.service.IGeneralSearchService;
import sk.fei.tp.ease.utils.PagingMapper;

@Service
@RequiredArgsConstructor
public class GeneralSearchService implements IGeneralSearchService {

    private final IEntitySearchQueryRepository searchRepository;
    private final EObjectRepository objectRepository;
    private final EDiagramRepository diagramRepository;
    private final PagingMapper mapper;

    @Override
    public PagedResult<GeneralSearchResultDto> searchEntities(SearchRequestDto searchRequest) {
        return mapper.mapPagedResultToDto(
                searchRepository.find(searchRequest),
                GeneralSearchResultDto.class
        );
    }

    @Override
    public GeneralSearchFilterContentsDto getFilterContents() {
        return new GeneralSearchFilterContentsDto(
                diagramRepository.findAllDiagramTypes(),
                objectRepository.findAllObjectTypes()
        );
    }
}
