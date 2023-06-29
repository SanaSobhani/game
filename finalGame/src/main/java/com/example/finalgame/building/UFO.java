package com.example.finalgame.building;

import com.example.finalgame.HelloApplication;

public class UFO extends DefensiveBuilding{
    public UFO(){
        super(4,8,new HelloApplication().getClass().getResource("B.ufo.png").toString());
    }
}
