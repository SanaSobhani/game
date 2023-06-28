package com.example.finalgame.hero;

import com.example.finalgame.HelloApplication;

public class StormTrooper extends Hero{
    public StormTrooper(){
        super(2,2,new HelloApplication().getClass().getResource("H.stormTrooper.png").toString());
    }
}
