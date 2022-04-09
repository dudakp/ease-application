package sk.fei.tp.ease.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import sk.fei.tp.ease.model.enums.ObjectType;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Table(name = "t_object")
@Entity
@Getter
@Setter
public class EObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Object_ID", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "Object_Type")
    private ObjectType type;

    @ElementCollection
    @CollectionTable(
            name = "t_diagramobjects",
            joinColumns = @JoinColumn(name = "Object_ID")
    )
    @Column(name = "Diagram_ID")
    private Set<Long> diagrams;

    @Column(name = "Name")
    private String name;

    @Column(name = "Alias")
    private String alias;

    @Column(name = "Author")
    private String author;

    @Column(name = "Version")
    private Integer version;

    @Column(name = "Note")
    private String note;

    @JoinColumn(name = "Package_ID")
    @OneToOne
    private EPackage ePackage;

    @Column(name = "CreatedDate")
    private LocalDateTime createdDate;

    @Column(name = "ModifiedDate")
    private LocalDateTime modifiedDate;

    @ManyToOne(targetEntity = EObject.class)
    @JoinColumn(name = "ParentID")
    @NotFound(action = NotFoundAction.IGNORE)
    private EObject parent;

    @OneToMany(targetEntity = EObjectProperty.class)
    @JoinColumn(name = "Object_ID")
    @NotFound(action = NotFoundAction.IGNORE)
    private List<EObjectProperty> objectProperties;

}
