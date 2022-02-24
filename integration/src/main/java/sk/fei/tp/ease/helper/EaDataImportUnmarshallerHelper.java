package sk.fei.tp.ease.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import sk.fei.tp.ease.dto.TableWithColumnValuesDto;
import sk.fei.tp.ease.dto.xml.XmlPackageWrapper;
import sk.fei.tp.ease.dto.xml.XmlTableWrapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EaDataImportUnmarshallerHelper {

    public List<TableWithColumnValuesDto> unmarshallSingleFile(MultipartFile file) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(XmlPackageWrapper.class);
        XmlPackageWrapper res = (XmlPackageWrapper) context.createUnmarshaller()
                .unmarshal(new InputStreamReader(file.getInputStream()));
        return TableWithColumnValuesDto.fromMap(res.getTables().stream()
                .collect(Collectors.groupingBy(XmlTableWrapper::getTableName,
                        Collectors.flatMapping(baseTableWrapper -> baseTableWrapper.getRows().stream(), Collectors.toList()))));
    }
}
