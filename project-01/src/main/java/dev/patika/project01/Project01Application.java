package dev.patika.project01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Project01Application {

    public static void main(String[] args) {
        SpringApplication.run(Project01Application.class, args);
    }

}
