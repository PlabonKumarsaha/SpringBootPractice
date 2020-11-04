package com.example.pks.SpringConfigWithAnnotation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("theCoach")
public class CricketCoach implements Coach{

    @Autowired
    @Qualifier("happyFortuneService")
    FortuneSerice fortuneSerice;

    public CricketCoach() {

        System.out.println("default const");
    }

    @Override
    public String getService() {
        return "something";
    }

    @Override
    public String getData() {
        String st = fortuneSerice.getFortuneService();
        return st;
    }

    public String getSomething(){
        String st = fortuneSerice.getFortuneService();
        return st;
    }
}
