package sk.fei.tp.ease.dto.xml;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "Table")
@XmlAccessorType(XmlAccessType.NONE)
public class XmlTableWrapper {

    @XmlAttribute(name = "name")
    private String tableName;

    @XmlElement(name = "Row")
    private List<XmlRowWrapper> rows;

}
