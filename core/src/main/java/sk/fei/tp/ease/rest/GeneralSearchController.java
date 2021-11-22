package sk.fei.tp.ease.rest;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fei.tp.ease.dto.domain.search.GeneralSearchResultDto;
import sk.fei.tp.ease.dto.request.SearchRequestDto;

import java.util.List;

@RestController
@RequestMapping("/core/search")
public class GeneralSearchController {

    @PutMapping(path = "/general")
    public List<GeneralSearchResultDto> searchGeneralEntity(@RequestBody SearchRequestDto search) {
        return null;
    }
}
