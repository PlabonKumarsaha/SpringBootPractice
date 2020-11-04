package com.example.pks.SpringConfigWithAnnotation;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneSerice{
    @Override
    public String getFortuneService() {
        return "Random fortuneService";
    }
}
