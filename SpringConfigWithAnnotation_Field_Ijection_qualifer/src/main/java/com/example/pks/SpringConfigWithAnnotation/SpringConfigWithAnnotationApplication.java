package com.example.pks.SpringConfigWithAnnotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class SpringConfigWithAnnotationApplication {

	/*
@Qualifier example
1. In this project there are multiple Service classes that implemnets the Fortuneservice.so if you want to autowire
it then spring beans will get confused who to specify..NoUnique exception will be given
2. so must specify the qualifer in order to uniquley identify which class is actually asked to be autowired
("happyFortuneService")

	*/


	public static void main(String[] args) {


		FileSystemXmlApplicationContext context =
				new FileSystemXmlApplicationContext("SpringCOnfigFIle.xml");
		Coach coach = context.getBean("theCoach",CricketCoach.class);

		System.out.println(coach.getData());
	}


}
