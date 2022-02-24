package sk.fei.tp.ease.dto.xml;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@XmlRootElement(name = "Column")
@XmlAccessorType(XmlAccessType.NONE)
public class XmlColumnWrapper {

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "value")
    private String value;

}


