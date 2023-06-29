package com.example.finalgame.building;

import com.example.finalgame.HelloApplication;

public class OldCastle extends NonDefensiveBuilding{
    public OldCastle(){
        super(8,new HelloApplication().getClass().getResource("B.oldCastle.png").toString());
    }
}
