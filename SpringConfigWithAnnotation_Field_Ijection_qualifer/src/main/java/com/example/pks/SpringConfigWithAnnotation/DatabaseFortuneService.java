package com.example.pks.SpringConfigWithAnnotation;


import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneSerice {
    @Override
    public String getFortuneService() {
        return "Database fortune Service";
    }
}
