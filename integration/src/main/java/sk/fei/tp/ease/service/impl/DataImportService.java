package sk.fei.tp.ease.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.multipart.MultipartFile;
import sk.fei.tp.ease.dto.TableWithColumnValuesDto;
import sk.fei.tp.ease.dto.req.XmlDataImportResponseDto;
import sk.fei.tp.ease.helper.EaDataImportUnmarshallerHelper;
import sk.fei.tp.ease.service.IDataImportService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DataImportService implements IDataImportService {

    private final EaDataImportUnmarshallerHelper eaUnmarshaller;
    private final EntityManager entityManager;
    private final PlatformTransactionManager platformTransactionManager;

    @Override
    public XmlDataImportResponseDto importSingleFile(MultipartFile file) {
        try {
            List<TableWithColumnValuesDto> tableData = eaUnmarshaller.unmarshallSingleFile(file);
            List<String> queries = tableData.stream()
                    .map(this::buildInsertQuery)
                    .collect(Collectors.toList());
            AtomicInteger numImportedRows = new AtomicInteger(0);
            for (String query : queries) {
                try {
                    TransactionTemplate tt = new TransactionTemplate(platformTransactionManager);
                    tt.execute(new TransactionCallbackWithoutResult() {
                        @Override
                        protected void doInTransactionWithoutResult(TransactionStatus status) {
                            Query nativeQuery = entityManager.createNativeQuery(query);
                            nativeQuery.executeUpdate();
                            numImportedRows.addAndGet(1);
                        }
                    });

                } catch (PersistenceException e) {
                    log.warn("Could not insert data to DB: {}", e.getMessage());
                }
            }
            log.info("Imported {} rows to DB", numImportedRows);
            return new XmlDataImportResponseDto(numImportedRows.get(), queries.size());
        } catch (JAXBException | IOException e) {
            throw new RuntimeException("unable to unmarshall provided file!");
        }

    }

    private String buildInsertQuery(TableWithColumnValuesDto data) {
        return "INSERT INTO " + data.getTableName()
                + " ( " + data.getColumnNames().stream().map(c -> "\"" + c + "\"").collect(Collectors.joining(",")) + " ) " +
                "VALUES ( " + data.getColumnValues().stream().map(v -> isNumeric(v) ? v : "'" + v.replace('\'', '"') + "'").collect(Collectors.joining(",")) + ")";
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
