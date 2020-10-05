package com.example.dependency_injection;

public class CricketCoach implements Coach {

/*    private FortuneService fortuneService;

    public CricketCoach(FortuneService fortuneService2){
        fortuneService=fortuneService2;
    }*/

    private  DietCoach dietCoach;
    CricketCoach(DietCoach thisDiet){
        dietCoach = thisDiet;
    }

    @Override
    public String getDailyWorkout() {
        return "Walk for one hour";
    }

    public String getDiet(){
        String returnString = dietCoach.giveDietAdvice();
        return returnString;
    }

    /*@Override
    public String getDailyFortuneService() {
        return  fortuneService.getFortune();
    }*/
}
