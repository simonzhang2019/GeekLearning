package com.spring.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfig {

    @Bean(name = "studentA")
    public Student createStudentA() {
        return new Student(1, "A Student");
    }

    @Bean(name = "studentB")
    public Student createStudentB() {
        return new Student(2, "B Student");
    }

    @Bean
    public Klass createKlass() {
        return new Klass();
    }

    @Bean
    public School createSchool() {
        return new School();
    }

}
