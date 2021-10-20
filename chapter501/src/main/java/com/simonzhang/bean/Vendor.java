package com.simonzhang.bean;

import org.springframework.context.annotation.Bean;

public class Vendor {
    private String id;
    private String name;

    public Vendor() {
        id = "03";
        name = "Vendor";
        System.out.println("--Vendor--init--");
    }

    public void print() {
        System.out.println("Just do a print. My name is " + name);
    }

}
