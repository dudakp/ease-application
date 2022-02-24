package sk.fei.tp.ease.dto;

import lombok.Data;
import sk.fei.tp.ease.dto.xml.XmlColumnWrapper;
import sk.fei.tp.ease.dto.xml.XmlRowWrapper;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class TableWithColumnValuesDto {
    private final String tableName;
    private final List<String> columnNames;
    private final List<String> columnValues;

    public TableWithColumnValuesDto(String tableName, List<XmlColumnWrapper> columns) {
        this.tableName = tableName;
        this.columnNames = columns.stream().map(XmlColumnWrapper::getName).collect(Collectors.toList());
        this.columnValues = columns.stream().map(XmlColumnWrapper::getValue).collect(Collectors.toList());
        if (this.columnValues.size() != this.columnNames.size()) {
            throw new UnsupportedOperationException("Number of column names must be equal to number of column values!");
        }
    }

    public static List<TableWithColumnValuesDto> fromMap(Map<String, List<XmlRowWrapper>> map) {
        return map.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream()
                        .map(row -> new TableWithColumnValuesDto(entry.getKey(), row.getColumns())))
                .collect(Collectors.toList());
    }
}
