package dev.patika.project01.repository;

import dev.patika.project01.entity.Course;
import dev.patika.project01.entity.Instructor;
import dev.patika.project01.entity.Student;
import io.swagger.models.auth.In;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor, Integer> {

    List<Instructor> findByName(String i);
    List<Instructor> findByNameContaining(String i);
    void deleteByName(String i);

}
