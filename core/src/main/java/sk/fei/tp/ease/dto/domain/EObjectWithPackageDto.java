package sk.fei.tp.ease.dto.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import sk.fei.tp.ease.model.enums.ObjectType;

import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class EObjectWithPackageDto extends EObjectDto{
    private EPackageDto ePackage;
}
