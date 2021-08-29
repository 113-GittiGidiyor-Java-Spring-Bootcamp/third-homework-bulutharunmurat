package dev.patika.project01.service;


import dev.patika.project01.entity.Instructor;
import dev.patika.project01.entity.Student;
import dev.patika.project01.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService implements BaseService<Instructor>{

    private final InstructorRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Instructor> findAll() {

        List<Instructor> courseList = new ArrayList<>();
        Iterable<Instructor> students = repository.findAll();
        students.iterator().forEachRemaining(courseList::add);
        return courseList;
    }

    @Override
    @Transactional(readOnly = true)
    public Instructor findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        return repository.save(instructor);
    }

    @Override
    @Transactional
    public Instructor update(Instructor instructor) {
        return repository.save(instructor);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public List<Instructor> findByNameContaining(String name) {
        return repository.findByNameContaining(name);
    }

    @Transactional
    public void deleteByName(String name){
        repository.deleteByName(name);
    }
}
