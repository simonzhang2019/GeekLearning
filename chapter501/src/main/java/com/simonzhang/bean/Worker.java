package com.simonzhang.bean;

import lombok.Data;

@Data
public class Worker {
    private String id;
    private String name;

    public void print() {
        System.out.println("Just do a print. My name is " + name);
    }
}
