package dev.patika.project01.util;


import dev.patika.project01.entity.*;

import dev.patika.project01.entity.Course;
import dev.patika.project01.entity.Instructor;
import dev.patika.project01.service.CourseService;
import dev.patika.project01.service.InstructorService;
import dev.patika.project01.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;


@Component
public class InitializerRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(InitializerRunner.class);

    @Autowired
    StudentService studentService;

    @Autowired
    CourseService courseService;

    @Autowired
    InstructorService instructorService;

    @Override
    public void run(String... args) throws Exception {


        Student student1 = Student.builder()
                .name("Harun Murat")
                .address("Istanbul")
                .birthDate(LocalDate.of(2001, Month.AUGUST,18))
                .gender("male")
                .build();

        Student student2 = Student.builder()
                .name("Bulut")
                .address("Bursa")
                .birthDate( LocalDate.of(1994, Month.MAY,04))
                .gender("male")
                .build();

        studentService.save(student1);
        studentService.save(student2);


        PermanentInstructor.PermanentInstructorBuilder<?, ?> permanentInstructor1=
                PermanentInstructor.builder()
                        .name("Tolga Ovatman")
                        .address("Istanbul")
                        .phoneNumber("00212220")
                        .fixedSalary(50.00F);

        VisitingResearcher.VisitingResearcherBuilder<?,?> visitingResearcher1=
                VisitingResearcher.builder()
                        .name("Tacettin")
                        .address("Istanbul")
                        .phoneNumber("051231")
                        .hourlySalary(40.00F);

        instructorService.save(permanentInstructor1.build());
        instructorService.save(visitingResearcher1.build());

        Course course1 = Course.builder()
                .code("CAL101")
                .creditScore(3.50F)
                .name("CALCULUS")
                .instructor(visitingResearcher1.
                        build())
                .build();

        Course course2 = Course.builder()
                .code("CS101")
                .creditScore(4.0F)
                .name("COMPUTER SCIENCE")
                .build();

        Course course3 = Course.builder()
                .code("ENG101")
                .creditScore(2.0F)
                .name("ENGLISH")
                .instructor(visitingResearcher1.build())
                .build();
        
        courseService.save(course1);
        courseService.save(course2);
        courseService.save(course3);

        courseService.findAll().forEach(course -> logger.info("{}", course));
    }
}
