package com.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class School {

    @Autowired
    private Klass klass;

    @PostConstruct
    public void init(){
        System.out.println("===Initialize School===");
    }

    public void ding(){
        System.out.println("===We are in School one===");
        klass.dong();
    }
}
