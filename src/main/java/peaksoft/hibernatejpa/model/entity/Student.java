package peaksoft.hibernatejpa.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import peaksoft.hibernatejpa.model.converters.YesOrNoBooleanConverter;
import peaksoft.hibernatejpa.model.embeddedclasses.Address;
import peaksoft.hibernatejpa.model.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author Beksultan
 */
@Entity
@Getter
@Setter
@ToString
public class Student {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_gen")
    @SequenceGenerator(
            name = "student_gen",
            sequenceName = "student_seq",
            allocationSize = 1
    )
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate birthDay;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Convert(converter = YesOrNoBooleanConverter.class)
    private boolean wantsNewsLetters;

    @Transient
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private int age;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "st_city_name")),
            @AttributeOverride(name = "street", column = @Column(name = "st_street_name")),
            @AttributeOverride(name = "number", column = @Column(name = "st_address_number"))
    })
    private Address address;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Course course;

    public int getAge() {
        return LocalDate.now().minusYears(birthDay.getYear()).getYear();
    }
}