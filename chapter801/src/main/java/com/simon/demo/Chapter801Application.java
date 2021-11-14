package com.simon.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.simon.demo.dao")
@SpringBootApplication
public class Chapter801Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter801Application.class, args);
	}

}
