package sk.fei.tp.ease.service;

import org.springframework.web.multipart.MultipartFile;
import sk.fei.tp.ease.dto.req.XmlDataImportResponseDto;

public interface IDataImportService {

    XmlDataImportResponseDto importSingleFile(MultipartFile file);
}
