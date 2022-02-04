package sk.fei.tp.ease.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fei.tp.ease.dto.domain.EObjectWithPackageDto;
import sk.fei.tp.ease.service.IObjectService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/core/object")
public class ObjectController {

    private final IObjectService objectService;


    @GetMapping("/{id}")
    public EObjectWithPackageDto getObject(@PathVariable("id") Long id) {
        return this.objectService.find(id);
    }

}
