package com.example.ioc.ioc;

public class BaseballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Run for an hour";
    }
}