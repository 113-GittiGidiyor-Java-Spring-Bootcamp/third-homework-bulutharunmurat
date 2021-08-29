package dev.patika.project01.controller;


import dev.patika.project01.entity.Instructor;
import dev.patika.project01.entity.PermanentInstructor;
import dev.patika.project01.entity.Student;
import dev.patika.project01.entity.VisitingResearcher;
import dev.patika.project01.service.InstructorService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorController {
    InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> findAll(){
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/instructors/{id}")
    public ResponseEntity<Instructor> findInstructorsById(@PathVariable int id){
        return new ResponseEntity<>(instructorService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/instructors")
    public Instructor saveInstructor(@RequestBody Instructor instructor){
        return instructorService.save(instructor);
    }

    @PostMapping("/instructors/visitingResearcher")
    public Instructor saveVisitingResearcher(@RequestBody VisitingResearcher visitingResearcher){
        return instructorService.save(visitingResearcher);
    }

    @PostMapping("/instructors/permanentInstructor")
    public Instructor savePermanentInstructor(@RequestBody PermanentInstructor permanentInstructor){
        return instructorService.save(permanentInstructor);
    }

    @PutMapping("/instructors")
    public Instructor updateInstructor(@RequestBody Instructor instructor){
        return instructorService.update(instructor);
    }

    @DeleteMapping("/instructors/{id}")
    public String deleteInstructorById(@PathVariable int id){
        instructorService.deleteById(id);
        return "instructor with "+ id + " id deleted";
    }

    @GetMapping("/instructors/findByNameContaining/{name}")
    public List<Instructor> findByNameContaining(@PathVariable String name){
        return instructorService.findByNameContaining(name);
    }

    @DeleteMapping("/instructors/byname/{name}")
    public String deleteInstructorByName(@PathVariable String name){
        instructorService.deleteByName(name);
        return "instructor with name " + name + " is deleted";
    }
}
