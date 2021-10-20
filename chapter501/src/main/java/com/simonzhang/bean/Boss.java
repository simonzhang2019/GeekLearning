package com.simonzhang.bean;

import org.springframework.stereotype.Component;

@Component
public class Boss {
    private String id;
    private String name;

    public Boss() {
        id = "02";
        name = "Boss";
        System.out.println("--Boss--init--");
    }

    public void print() {
        System.out.println("Just do a print. My name is " + name);
    }
}
