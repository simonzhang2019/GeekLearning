package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.spring.demo.*;

import javax.annotation.Resource;

@Component
public class SchoolDing {

    @Autowired
    private School school;

    public void print() {
        // 运行效果将通过单测来观察（单测用例请参考：Chapter502ApplicationTests）
        school.ding();
    }
}
