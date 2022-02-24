package sk.fei.tp.ease.dto.xml;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "Row")
@XmlAccessorType(XmlAccessType.NONE)
public class XmlRowWrapper {

    @XmlElement(name = "Column")
    private List<XmlColumnWrapper> columns;
}
