package com.spring.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import java.io.Serializable;

@Data
@ToString
public class Student {

    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @PostConstruct
    public void init(){
        System.out.println("===Initialize Student===");
    }

    public void print() {
        System.out.println("I'm a student and my name is " + this.name);
    }

}
