package peaksoft.hibernatejpa.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Beksultan
 */
@Entity
@Getter @Setter
public class Course {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_gen")
    @SequenceGenerator(
            name = "course_gen",
            sequenceName = "course_seq",
            allocationSize = 1
    )
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    private String name;

    @OneToMany(cascade = {CascadeType.MERGE},
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            mappedBy = "course")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonIgnore
    private List<Student> students = new ArrayList<>(0);

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(Long studentId) {
        this.students.removeIf(student -> Objects.equals(student.getId(), studentId));
    }
}
