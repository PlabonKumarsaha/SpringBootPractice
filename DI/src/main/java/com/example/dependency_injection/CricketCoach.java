package com.example.dependency_injection;

public class CricketCoach implements Coach {

    private FortuneService fortuneService;

    public CricketCoach(FortuneService fortuneService2){
        fortuneService=fortuneService2;
    }
    @Override
    public String getDailyWorkout() {
        return "Walk for one hour";
    }

    @Override
    public String getDailyFortuneService() {
        return  fortuneService.getFortune();
    }
}
