package sk.fei.tp.ease.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_objectproperties")
public class EObjectProperty {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PropertyID", nullable = false)
    private int propertyId;

    @Column(name = "Property")
    private String property;

    @Column(name = "Value")
    private String value;

    @Column(name = "Notes")
    private String notes;

}
