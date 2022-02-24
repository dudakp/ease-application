package sk.fei.tp.ease.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalTime;

@Table(name="search_history")
@Entity
@Getter
@Setter
public class SearchHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="user")
    private String user;
    @Column(name="time")
    private LocalTime time;
    @Column(name="searched_expression")
    private String searchedExpression;
}