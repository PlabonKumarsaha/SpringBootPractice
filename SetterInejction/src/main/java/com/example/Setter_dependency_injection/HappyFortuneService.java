package com.example.Setter_dependency_injection;


//only implements the fortune service
public class HappyFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return "Today is your lucky day :3 ";
    }
}
