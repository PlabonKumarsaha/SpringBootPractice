package com.example.dependency_injection;

public class HealthyDiet implements  DietCoach{
    @Override
    public String giveDietAdvice() {
        return "AVoid FastFood";
    }
}
