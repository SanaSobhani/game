package com.example.finalgame.hero;

import com.example.finalgame.HelloApplication;

public class Witch extends Hero{
    public Witch() {
        super(2,3,new HelloApplication().getClass().getResource("H.witch.png").toString());
    }
}
