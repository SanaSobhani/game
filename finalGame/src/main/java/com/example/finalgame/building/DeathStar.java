package com.example.finalgame.building;

import com.example.finalgame.HelloApplication;
import javafx.scene.image.Image;

public class DeathStar extends DefensiveBuilding {
    public DeathStar(){
        super(5,9,new HelloApplication().getClass().getResource("B.starDeath2.png").toString(),new HelloApplication().getClass().getResource("blueRay2.png").toString());
    }
}
