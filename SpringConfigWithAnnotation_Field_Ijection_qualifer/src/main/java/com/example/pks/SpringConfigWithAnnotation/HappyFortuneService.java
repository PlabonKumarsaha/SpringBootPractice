package com.example.pks.SpringConfigWithAnnotation;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneSerice{
    @Override
    public String getFortuneService() {
        return "Happy Fortune";
    }
}
