package sk.fei.tp.ease.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Instant;
import java.time.LocalDateTime;

@Table(name = "t_package")
@Entity
@Getter
@Setter
public class EPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Package_ID", nullable = false)
    private Long id;

    @Column(name = "Name")
    private String name;

    @ManyToOne(targetEntity = EPackage.class)
    @JoinColumn(name = "Parent_ID")
    @NotFound(action = NotFoundAction.IGNORE)
    private EPackage parent;

    @Column(name = "CreatedDate")
    private LocalDateTime createdDate;

    @Column(name = "ModifiedDate")
    private LocalDateTime modifiedDate;

    @Column(name = "Notes")
    private String notes;

    @Column(name = "Version")
    private Integer version;
}
