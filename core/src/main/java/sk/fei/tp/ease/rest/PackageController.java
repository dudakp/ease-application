package sk.fei.tp.ease.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fei.tp.ease.dto.domain.EPackageDto;
import sk.fei.tp.ease.service.IPackageService;

@RestController
@RequestMapping("/core/package")
@RequiredArgsConstructor
public class PackageController {

    private final IPackageService packageService;

    @GetMapping("/{id}")
    public EPackageDto getPackage(@PathVariable("id") Long id) {
        return packageService.findById(id);
    }
}
