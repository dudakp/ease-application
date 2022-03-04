package sk.fei.tp.ease.dto.req;

import lombok.Data;

@Data
public class XmlDataImportResponseDto {

    private final int numImportedRows;
    private final int numProvidedRows;

}
