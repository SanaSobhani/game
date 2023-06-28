package com.example.finalgame.building;

import com.example.finalgame.HelloApplication;

public class WatchTower extends NonDefensiveBuilding{
    public WatchTower(){
        super(4,new HelloApplication().getClass().getResource("B.watchTower.png").toString());
    }
}
