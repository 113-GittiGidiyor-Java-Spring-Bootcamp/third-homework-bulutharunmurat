package dev.patika.project01.service;


import dev.patika.project01.entity.Course;
import dev.patika.project01.entity.Student;
import dev.patika.project01.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService implements BaseService<Course> {

    private final CourseRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {

        List<Course> courseList = new ArrayList<>();
        Iterable<Course> students = repository.findAll();
        students.iterator().forEachRemaining(courseList::add);
        return courseList;
    }

    @Override
    @Transactional(readOnly = true)
    public Course findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return repository.save(course);
    }

    @Override
    @Transactional
    public Course update(Course course) {
        return repository.save(course);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public List<Course> findByNameContaining(String name) {
        return repository.findByNameContaining(name);
    }

    @Transactional
    public void deleteByName(String name){
        repository.deleteByName(name);
    }
}
