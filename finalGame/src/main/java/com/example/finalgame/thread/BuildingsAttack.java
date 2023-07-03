package com.example.finalgame.thread;

import com.example.finalgame.HelloApplication;
import com.example.finalgame.building.*;
import com.example.finalgame.hero.Hero;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BuildingsAttack extends Thread {
    private Hero target;
   private DefensiveBuilding building;
   //private ImageView buildingView;
    private ImageView ray;
   public BuildingsAttack(DefensiveBuilding building,ImageView ray){
        this.ray = ray;
        this.building  = building;
    }
    @FXML
    public void run(){
        ray.setImage(building.getFire());
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(ray);
        if(building instanceof DeathStar)
        {
            transition.setByX(100);
            transition.setByY(100);
        }
        if(building instanceof Canon)
        {
            transition.setByX(200);
            transition.setByY(50);
        }
        if(building instanceof WatchTower)
        {
            transition.setByX(-100);
            transition.setByY(300);
        }
        if(building instanceof SandCastle)
        {
            transition.setByX(100);
            transition.setByY(300);
        }
        if(building instanceof UFO)
        {
            transition.setByX(0);
            transition.setByY(300);
        }
        transition.setCycleCount(100);
        transition.play();
    }
}
