package sk.fei.tp.ease.model;

import lombok.Data;
import sk.fei.tp.ease.model.enums.ConnectorType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_connector", schema = "public", catalog = "ease")
@Data
public class EConnector {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Connector_ID", nullable = false)
    private Integer connectorId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Connector_Type")
    @Enumerated(EnumType.STRING)
    private ConnectorType connectorType;

    @JoinColumn(name = "Start_Object_ID")
    @OneToOne
    private EObject startObject;

    @JoinColumn(name = "End_Object_ID")
    @OneToOne
    private EObject endObject;

    @Column(name = "DiagramID")
    private Integer diagramId;

}
