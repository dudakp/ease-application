package sk.fei.tp.ease.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import sk.fei.tp.ease.model.enums.DiagramType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Table(name = "t_diagram")
@Entity
@Getter
@Setter
public class EDiagram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Diagram_ID", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "Package_ID")
    private EPackage tPackage;

    @ManyToOne(targetEntity = EDiagram.class)
    @JoinColumn(name = "ParentID")
    @NotFound(action = NotFoundAction.IGNORE)
    private EDiagram parent;

    @ManyToMany
    @JoinTable(name = "t_diagramobjects",
            joinColumns = {@JoinColumn(name = "Diagram_ID")},
            inverseJoinColumns = {@JoinColumn(name = "Object_ID")}
    )
    @NotFound(action = NotFoundAction.IGNORE)
    private List<EObject> objects;

    @Enumerated(EnumType.STRING)
    @Column(name = "Diagram_Type")
    private DiagramType diagramType;

    @Column(name = "Name")
    private String name;

    @Column(name = "Version")
    private Integer version;

    @Column(name = "Author")
    private String author;
}
