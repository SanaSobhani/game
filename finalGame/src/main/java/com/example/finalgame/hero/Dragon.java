package com.example.finalgame.hero;

import com.example.finalgame.HelloApplication;

public class Dragon extends Hero{
    public Dragon(){
        super(3,2,new HelloApplication().getClass().getResource("H.dragon.png").toString());
    }
}
