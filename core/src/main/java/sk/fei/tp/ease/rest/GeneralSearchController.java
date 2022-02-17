package sk.fei.tp.ease.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fei.tp.ease.dto.common.PagedResult;
import sk.fei.tp.ease.dto.domain.search.GeneralSearchFilterContentsDto;
import sk.fei.tp.ease.dto.domain.search.GeneralSearchResultDto;
import sk.fei.tp.ease.dto.request.SearchRequestDto;
import sk.fei.tp.ease.service.IGeneralSearchService;

import javax.validation.Valid;

@RestController
@RequestMapping("/core/search")
@RequiredArgsConstructor
public class GeneralSearchController {

    private final IGeneralSearchService generalSearchService;

    @PutMapping(path = "/general")
    public PagedResult<GeneralSearchResultDto> searchGeneralEntity(@Valid @RequestBody SearchRequestDto search) {
        return this.generalSearchService.searchEntities(search);
    }

    @GetMapping("/filterContents")
    public GeneralSearchFilterContentsDto getFilterContents() {
        return generalSearchService.getFilterContents();
    }
}
