package com.simonzhang.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Worker worker = (Worker) context.getBean("worker01");
        worker.print();

        Boss boss = context.getBean(Boss.class);
        boss.print();

        Vendor vendor = context.getBean(Vendor.class);
        vendor.print();
    }
}
