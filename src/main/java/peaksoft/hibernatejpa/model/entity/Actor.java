package peaksoft.hibernatejpa.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author Beksultan
 */
@Entity
@Getter @Setter
public class Actor {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "actor_gen")
    @SequenceGenerator(
            name = "actor_gen",
            sequenceName = "actor_seq",
            allocationSize = 1)
    private Long id;

    private String fullName;

    @ManyToMany
    private List<Movie> movies;
}
