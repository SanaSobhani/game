package com.example.finalgame.building;

import com.example.finalgame.HelloApplication;

public class WatchTower extends DefensiveBuilding{
    public WatchTower(){
        super(4,6,new HelloApplication().getClass().getResource("B.watchTower.png").toString(),new HelloApplication().getClass().getResource("redBall.png").toString());
    }
}
