package com.example.dependency_injection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ConstDependencyInjectionApplication {

    public static void main(String[] args) {
     //   SpringApplication.run(ConstDependencyInjectionApplication.class, args);
        
       /* DI is a technique for passing dependencies into an object’s constructor.
       If the object has been loaded from the container, then its dependencies will be automatically supplied by the container.
       This allows you to consume a dependency without having to manually create an instance.
       This reduces coupling and gives you greater control over the lifetime of object instances.

        Dependency injection is basically of two type .constructor injection and setter injection
         process of const injection :
         1.Define the dependency interface and class
         2.create a constructor for the injection
         3.configure the dependency injection in config file

         here, fortuneService interface just abstracts the fortune that is being provided to Coaches
         HappyFortuneClass implements this interface .
         Creating a const in BaseballCoach for dependency injection
        */



        /*


         */


        /*ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
*/
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("applicationContext.xml");

        //step 3 : reatriving bean from the config..Here mycoach is the same as set up in the beans..and Coach
        //is the interface of the implementation where the actual class is saved in the config file
        Coach theCoach = (Coach) context.getBean("myCoach");
        System.out.println(theCoach.getDailyWorkout());

        //call method on the bean
      /*  System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortuneService());


        //close the context
       // context.

        HappyFortuneService myFortuneService = new HappyFortuneService();
        Coach myCoach = new BaseballCoach(myFortuneService);

        System.out.println();*/




    }

}
