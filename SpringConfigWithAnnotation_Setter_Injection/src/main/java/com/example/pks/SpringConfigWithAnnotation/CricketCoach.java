package com.example.pks.SpringConfigWithAnnotation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("theCoach")
public class CricketCoach implements Coach{
    FortuneSerice fortuneSerice;

    public CricketCoach() {

        System.out.println("default const");
    }

  /*  @Autowired
    CricketCoach(FortuneSerice fortuneSerice){
        this.fortuneSerice = fortuneSerice;
    }*/

    @Autowired
    public void setFortuneSerice(FortuneSerice fortuneSerice){
        this.fortuneSerice = fortuneSerice;
    }

    @Override
    public String getService() {
        return "something";
    }
}
