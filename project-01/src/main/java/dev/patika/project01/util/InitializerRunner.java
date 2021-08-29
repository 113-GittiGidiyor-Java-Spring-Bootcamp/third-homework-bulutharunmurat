package dev.patika.project01.util;


import dev.patika.project01.entity.Course;
import dev.patika.project01.entity.PermanentInstructor;
import dev.patika.project01.entity.Student;
import dev.patika.project01.entity.VisitingResearcher;
import dev.patika.project01.repository.CourseRepository;
import dev.patika.project01.repository.InstructorRepository;
import dev.patika.project01.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class InitializerRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(InitializerRunner.class);

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    InstructorRepository instructorRepository;

    @Override
    public void run(String... args) throws Exception {


//        Student student = new Student(5, "Deneme", "Istanbul", LocalDate.now(), "male");
//        studentRepository.save(student);

        studentRepository.save(Student.builder().name("Harun Murat").address("Istanbul").birthDate(LocalDate.now()).gender("male").build());
        studentRepository.save(Student.builder().name("Bulut").address("Bursa").birthDate(LocalDate.now()).gender("male").build());

        PermanentInstructor.PermanentInstructorBuilder<?, ?> permanentInstructor1=
                PermanentInstructor.builder().name("Tolga Ovatman").address("Istanbul").phoneNumber("00212220").fixedSalary(50.00F);
        instructorRepository.save(permanentInstructor1.build());

        VisitingResearcher.VisitingResearcherBuilder<?,?> visitingResearcher1=
                VisitingResearcher.builder().name("Tacettin").address("Istanbul").phoneNumber("051231").hourlySalary(40.00F);

        instructorRepository.save(visitingResearcher1.build());

        courseRepository.save(Course.builder().code("CAL101").creditScore(3.50F).name("CALCULUS").build());
        courseRepository.save(Course.builder().code("CS101").creditScore(4.0F).name("COMPUTER SCIENCE").build());
        courseRepository.save(Course.builder().code("ENG101").creditScore(2.0F).name("ENGLISH").build());


//        Student student1 = (Student) studentRepository.findByName("Bulut");
//        Set<Student> students = null;
//        students.add(student1);
//        Course course1 = (Course) courseRepository.findByName("CALCULUS");
//        course1.setStudentList(students);

        courseRepository.findAll().forEach(student -> logger.info("{}", student));
    }
}
