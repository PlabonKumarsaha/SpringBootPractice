package com.example.pks.SpringConfigWithAnnotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class SpringConfigWithAnnotationApplication {

	/*
	 1.define the dependency interface and class
	 2.take the overridden method
	 3. put component on the class you want to create instance of the class you want to create..
	 - the paramenter of the component is optoonal..if you add a paramter the para meter and instance value must be same
      4.add autowired to the constructor
      5.now create a filesytemXMLapplication context and mention the class name to get instase

	*/


	public static void main(String[] args) {


		FileSystemXmlApplicationContext context =
				new FileSystemXmlApplicationContext("SpringCOnfigFIle.xml");
		Coach coach = context.getBean("theCoach",Coach.class);

		System.out.println(coach.getService());
	}


}
