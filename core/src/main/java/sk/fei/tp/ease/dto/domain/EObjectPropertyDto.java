package sk.fei.tp.ease.dto.domain;

import lombok.Data;

@Data
public class EObjectPropertyDto {
    private Long propertyId;
    private String property;
    private String value;
    private String notes;
}
