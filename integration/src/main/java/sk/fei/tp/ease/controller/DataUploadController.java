package sk.fei.tp.ease.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sk.fei.tp.ease.service.IDataImportService;

@RestController
@RequestMapping("/integ/eaUpload")
@RequiredArgsConstructor
public class DataUploadController {

    private final IDataImportService dataImportService;

    @PostMapping("/uploadSingle")
    public Object uploadFile(@RequestParam("file") MultipartFile file) {
        return dataImportService.importSingleFile(file);
    }
}
