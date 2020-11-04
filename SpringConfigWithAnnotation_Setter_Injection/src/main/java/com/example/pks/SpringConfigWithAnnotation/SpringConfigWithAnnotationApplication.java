package com.example.pks.SpringConfigWithAnnotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class SpringConfigWithAnnotationApplication {

	/*
	Setter injection
	1. create a fortune interface
	2. implement the interface with another class
	3. add an instance of the fortune class in the cricketCoach class
	4. add component annotation on the CricketCoach class
	5.add a setter method in the class and add a autowired annotation in the setter class

	-also use autowired on any method to do setter injection
	*/


	public static void main(String[] args) {


		FileSystemXmlApplicationContext context =
				new FileSystemXmlApplicationContext("SpringCOnfigFIle.xml");
		Coach coach = context.getBean("theCoach",Coach.class);

		System.out.println(coach.getService());
	}


}
