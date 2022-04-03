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
public class Movie {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movie_gen")
    @SequenceGenerator(name = "movie_gen",
            sequenceName = "movie_seq",
            allocationSize = 1)
    private Long id;

    private String name;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Director director;

    @ManyToMany(cascade = CascadeType.MERGE,
            mappedBy = "movies")
    private List<Actor> actors;
}
