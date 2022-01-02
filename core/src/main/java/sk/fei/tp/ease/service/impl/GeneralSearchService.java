package sk.fei.tp.ease.service.impl;

import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;
import sk.fei.tp.ease.dto.domain.search.GeneralSearchResultDto;
import sk.fei.tp.ease.dto.request.SearchRequestDto;
import sk.fei.tp.ease.repository.EntitySearchRepository;
import sk.fei.tp.ease.service.IGeneralSearchService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GeneralSearchService implements IGeneralSearchService {

    private final EntitySearchRepository searchRepository;
    private final DozerBeanMapper mapper;

    @Override
    public List<GeneralSearchResultDto> searchEntities(SearchRequestDto searchRequest) {
        return searchRepository.findByNameContainingIgnoreCase(searchRequest.getName()).stream()
                .map(r->mapper.map(r, GeneralSearchResultDto.class))
                .collect(Collectors.toList());
    }
}
