package dev.patika.project01.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data //-> @RequiredArgsConstructor, @Getter, @Setter, @EqualsAndHashCode, @ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity //Spring DATA JPA
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String code;
    private Float creditScore;

    @ManyToMany(mappedBy = "courseList", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Student> studentList;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Instructor instructor;

}
