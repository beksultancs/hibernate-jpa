package peaksoft.hibernatejpa.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;
import peaksoft.hibernatejpa.model.converters.YesOrNoBooleanConverter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @author Beksultan
 */
@Entity
@Getter
@Setter
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

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDay; // yyyy-MM-dd - 2022-04-03

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Convert(converter = YesOrNoBooleanConverter.class)
    private Boolean wantsNewsLetters;

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

    public int getAge() {
        return LocalDate.now().minusYears(birthDay.getYear()).getYear();
    }
}