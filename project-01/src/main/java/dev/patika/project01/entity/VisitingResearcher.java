package dev.patika.project01.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.util.List;
import java.util.Objects;


@Data //-> @RequiredArgsConstructor, @Getter, @Setter, @EqualsAndHashCode, @ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity //Spring DATA JPA
@SuperBuilder
public class VisitingResearcher extends Instructor {

    private Float hourlySalary;

}
