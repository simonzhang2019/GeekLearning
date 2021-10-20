package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter502ApplicationTests {

	@Autowired
	private SchoolDing schoolDing;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testStarter() {
		schoolDing.print();
	}
}
