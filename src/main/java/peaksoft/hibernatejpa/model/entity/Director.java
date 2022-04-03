package peaksoft.hibernatejpa.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author Beksultan
 */
@Entity
@Getter
@Setter
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.MERGE,
            mappedBy = "director")
    private List<Movie> movies;

}
