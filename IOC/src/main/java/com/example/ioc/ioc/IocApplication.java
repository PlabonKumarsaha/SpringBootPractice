package com.example.ioc.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class IocApplication {

    public static void main(String[] args) {
        SpringApplication.run(IocApplication.class, args);

        // write your code here
        //this can work for various classes but still it is hardcoded
       /* Coach theCoach = new BaseballCoach();
        Coach theCoach = new CricketCoach();
        System.out.println(theCoach.getDailyWorkout());

        */


        /*
        Spring development process
         step 1.configuring spring beans : create an xml file..here it is applicationContext.xml
         step 2.Create a spring container
         step 3.Retrieve beans from spring container

         */

        //step 2 : passing the config file to the XML path context
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("src/main/resources/applicationContext.xml");

        //step 3 : retriving  bean from the config..Here mycoach is the same as set up in the beans..and Coach
        //is the interface of the implementation where the actual class is saved in the config file
        Coach theCoach = context.getBean("myCoach",Coach.class);

        //call method on the bean
        System.out.println(theCoach.getDailyWorkout());

        //close the context
        context.close();



    }

}
