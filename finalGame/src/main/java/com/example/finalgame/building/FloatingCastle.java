package com.example.finalgame.building;

import com.example.finalgame.HelloApplication;

public class FloatingCastle extends NonDefensiveBuilding{
    public FloatingCastle(){
        super(5,new HelloApplication().getClass().getResource("B.floatingCastle.png").toString());
    }
}
