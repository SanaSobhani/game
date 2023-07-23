package com.example.finalgame.building;

import com.example.finalgame.HelloApplication;

public class SandCastle extends DefensiveBuilding{
    public SandCastle(){
        super(9,5,new HelloApplication().getClass().getResource("B.sandCastle.png").toString(),new HelloApplication().getClass().getResource("blackBall.png").toString());
    }
}
