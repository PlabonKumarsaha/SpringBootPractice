package com.example.Setter_dependency_injection;

public class BaseballCoach implements Coach {

    //creating a fortune service instance
    FortuneService fortuneService;

    BaseballCoach(FortuneService newFortuneService){
        this.fortuneService = newFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run for an hour";
    }



    @Override
    public String getDailyFortuneService() {
        //dependency == helper
        return fortuneService.getFortune();
    }
}