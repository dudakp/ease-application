package sk.fei.tp.ease.service;

import org.springframework.web.multipart.MultipartFile;

public interface IDataImportService {

    Object importSingleFile(MultipartFile file);
}
