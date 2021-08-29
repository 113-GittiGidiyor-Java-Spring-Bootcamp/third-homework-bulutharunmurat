package dev.patika.project01.controller;


import dev.patika.project01.entity.Course;
import dev.patika.project01.entity.Student;
import dev.patika.project01.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> findAll(){
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/courses")
    public Course saveCourse(@RequestBody Course course){
        return courseService.save(course);
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> findCourseById(@PathVariable int id){
        return new ResponseEntity<>(courseService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return courseService.update(course);
    }

    @DeleteMapping("/courses/{id}")
    public String deleteById(@PathVariable int id){
        courseService.deleteById(id);
        return "course with "+ id + " id deleted";
    }

    @GetMapping("/courses/findByNameContaining/{name}")
    public List<Course> findByNameContaining(@PathVariable String name){
        return courseService.findByNameContaining(name);
    }

    @DeleteMapping("/courses/byname/{name}")
    public String deleteCourseByName(@PathVariable String name){
        courseService.deleteByName(name);
        return "course with name " + name + " is deleted";
    }
}
