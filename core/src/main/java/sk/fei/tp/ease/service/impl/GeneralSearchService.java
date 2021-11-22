package sk.fei.tp.ease.service.impl;

import org.springframework.stereotype.Service;
import sk.fei.tp.ease.dto.domain.search.GeneralSearchResultDto;
import sk.fei.tp.ease.service.IGeneralSearchService;

import java.util.List;

@Service
public class GeneralSearchService implements IGeneralSearchService {
    @Override
    public List<GeneralSearchResultDto> searchEntities(GeneralSearchResultDto searchRequest) {
        return null;
    }
}
