package com.example.finalgame.thread;

import com.example.finalgame.HelloApplication;
import com.example.finalgame.building.*;
import com.example.finalgame.hero.Hero;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class BuildingsAttack extends Thread {
    private Hero target;
   private DefensiveBuilding building;
   //private ImageView buildingView;
    private ImageView ray;
    private ArrayList<ImageView> heroes = new ArrayList<>();
   public BuildingsAttack(DefensiveBuilding building,ImageView ray,ArrayList<ImageView>heroes){
        this.ray = ray;
        this.building  = building;
        this.heroes = heroes;
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
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (ImageView hero : heroes) {
                    if (hero.getBoundsInParent().intersects(ray.getBoundsInParent()))
                        ((Hero) hero.getImage()).setLevelOfHealth(((Hero) hero.getImage()).getLevelOfHealth() - 1);
                    if (((Hero) hero.getImage()).getLevelOfHealth() == 0) {
                        Platform.runLater(() -> HelloApplication.root.getChildren().remove(hero));
                        heroes.remove(hero);
                    }
                    System.out.println("hero health " + ((Hero) hero.getImage()).getLevelOfHealth());
                }

            }} ,0,100*building.getLevelOfHealth());}

    }
