package dev.patika.project01.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@EqualsAndHashCode
//@ToString
@Data //-> @RequiredArgsConstructor, @Getter, @Setter, @EqualsAndHashCode, @ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity //Spring DATA JPA
@Builder
public class Student {

    @Id//for persistence context - primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    private LocalDate birthDate;
    private String gender;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Course> courseList;

}
