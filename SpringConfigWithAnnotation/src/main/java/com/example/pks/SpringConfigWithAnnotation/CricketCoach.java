package com.example.pks.SpringConfigWithAnnotation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("theCoach")
public class CricketCoach implements Coach{

    @Autowired
    FortuneSerice fortuneSerice;
    CricketCoach(FortuneSerice fortuneSerice){
        this.fortuneSerice = fortuneSerice;
    }

    @Override
    public String getService() {
        return "something";
    }
}
