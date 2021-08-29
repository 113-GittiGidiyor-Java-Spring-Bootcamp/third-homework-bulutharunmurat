package dev.patika.project01.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data //-> @RequiredArgsConstructor, @Getter, @Setter, @EqualsAndHashCode, @ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity //Spring DATA JPA
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String address;
    private String phoneNumber;

    @OneToMany(mappedBy = "instructor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Course> courseList = new ArrayList<>();

}
