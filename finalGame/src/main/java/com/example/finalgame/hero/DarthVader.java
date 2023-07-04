package com.example.finalgame.hero;

import com.example.finalgame.HelloApplication;

public class DarthVader extends Hero{
    public DarthVader(){
        super(4,4,new HelloApplication().getClass().getResource("H.darthVader.png").toString(),new HelloApplication().getClass().getResource("darthFire.png").toString());
    }
}
