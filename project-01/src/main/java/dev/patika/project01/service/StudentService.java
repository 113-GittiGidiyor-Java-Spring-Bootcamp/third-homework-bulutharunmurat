package dev.patika.project01.service;



import dev.patika.project01.entity.Student;
import dev.patika.project01.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentService implements BaseService<Student> {

    private final StudentRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {

        List<Student> studentList = new ArrayList<>();
        Iterable<Student> students = repository.findAll();
        students.iterator().forEachRemaining(studentList::add);
        return studentList;
    }

    @Override
    @Transactional(readOnly = true)
    public Student findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    @Transactional
    public Student update(Student student) {
        return repository.save(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public int getNumberOfStudents() {
        return repository.getNumberOfStudents();
    }

    public List<?> getGenderWithGrouping() {
        return repository.getGenderWithGrouping();
    }

    public List<?> getGenderWithGroupingWithNativeQuery() {
        return repository.getGenderWithGroupingWithNativeQuery();
    }

    public List<Student> getStudentWithName(String name) {
        return repository.findByName(name);
    }

    public List<Student> findByNameContaining(String name) {
        return repository.findByNameContaining(name);
    }

    @Transactional
    public void deleteByName(String name){
        repository.deleteByName(name);
    }
}
