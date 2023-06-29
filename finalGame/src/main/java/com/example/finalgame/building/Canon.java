package com.example.finalgame.building;

import com.example.finalgame.HelloApplication;

public class Canon extends DefensiveBuilding{
    public Canon(){
        super(4,8,new HelloApplication().getClass().getResource("B.canonOriginal.png").toString());
    }
}
