package sk.fei.tp.ease.rest;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fei.tp.ease.dto.domain.EObjectDto;
import sk.fei.tp.ease.service.IObjectService;

import javax.websocket.server.PathParam;

@RestController
@RequiredArgsConstructor
@RequestMapping("/core/object")
public class ObjectController {

    private final IObjectService objectService;


    @GetMapping("/{id}")
    @Operation(description = "ano")
    public EObjectDto getObject(@PathParam("id") Long id) {
        return this.objectService.find(id);
    }
}
