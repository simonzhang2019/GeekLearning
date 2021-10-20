package com.spring.demo;

import lombok.Data;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Data
public class Klass { 

    @Resource(name = "studentA")
    private Student studentA;

    @Resource(name = "studentB")
    private Student studentB;

    @PostConstruct
    public void init(){
        System.out.println("===Initialize Klass===");
    }

    public void dong(){
        System.out.println("===We are in class one===");
        studentA.print();
        studentB.print();
    }
    
}
