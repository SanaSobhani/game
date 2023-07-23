package com.example.finalgame.thread;

import com.example.finalgame.HelloApplication;
import com.example.finalgame.building.Building;
import com.example.finalgame.hero.*;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MovingHeroes extends Thread{
    private ImageView imageView;
    private Hero hero;
    private ArrayList<ImageView>buildings = new ArrayList<>();
    private ImageView target;
    private ImageView fire;
    private Building building;
    private TranslateTransition fireTransition;
   public MovingHeroes(ImageView imageView, Hero hero,ArrayList<ImageView>buildings,ImageView fire){
        this.imageView= new ImageView();
        this.hero = hero;
        this.imageView = imageView;
        this.buildings = buildings;
        this.fire = fire;
   }
    @Override
    public void run(){
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(imageView);
        findingClosest();
        if(hero instanceof Dragon) {
            imageView.setLayoutX(target.getLayoutX()+100);
            imageView.setLayoutY(target.getLayoutY()-90);
            fire.setLayoutY(imageView.getLayoutY()+55);
            fire.setLayoutX(imageView.getLayoutX()+76);
            fireTransition = new TranslateTransition();
            fireTransition.setNode(fire);
            fireTransition.setByX(200);
            fireTransition.setByY(200);
            fireTransition.setCycleCount(100);
         }
        if(hero instanceof Witch){
            imageView.setLayoutX(target.getLayoutX()+110);
            imageView.setLayoutY(target.getLayoutY()-90);
            fire.setLayoutY(imageView.getLayoutY()+60);
            fire.setLayoutX(imageView.getLayoutX()-50);
            fireTransition = new TranslateTransition();
            fireTransition.setNode(fire);
            fireTransition.setByX(-200);
            fireTransition.setByY(100);
            fireTransition.setCycleCount(100);
        }
        if(hero instanceof DarthVader)
        {
            imageView.setLayoutX(target.getLayoutX()+200);
            imageView.setLayoutY(target.getLayoutY()-70);
            fire.setLayoutY(imageView.getLayoutY()+60);
            fire.setLayoutX(imageView.getLayoutX()-50);
            fireTransition = new TranslateTransition();
            fireTransition.setNode(fire);
            fireTransition.setByX(-200);
            fireTransition.setByY(0);
            fireTransition.setCycleCount(100);
        }
        if(hero instanceof StormTrooper ){
            imageView.setLayoutX(target.getLayoutX()+90);
            imageView.setLayoutY(target.getLayoutY()-90);
            fire.setLayoutY(imageView.getLayoutY()+30);
            fire.setLayoutX(imageView.getLayoutX()-62);
            fireTransition = new TranslateTransition();
            fireTransition.setNode(fire);
            fireTransition.setByX(-100);
            fireTransition.setByY(0);
            fireTransition.setCycleCount(100);}

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(fire.getBoundsInParent().intersects(target.getBoundsInParent()))
                    building.setLevelOfHealth(building.getLevelOfHealth()-1);
                if(building.getLevelOfHealth()==0){
                    Platform.runLater(()->HelloApplication.root.getChildren().remove(target));
                    Platform.runLater(()->HelloApplication.root.getChildren().remove(fire));
                    buildings.remove(target);
                }
                System.out.println("run "+building.getLevelOfHealth());
            }
        },0,1000*building.getLevelOfHealth()/ hero.getAttackPower());
        fireTransition.play();
   }
    private void findingClosest(){
       double distance ;
       double minDistance = Double.MAX_VALUE;
       for(ImageView pointer : buildings)
       {
           System.out.println(buildings.size());
           double x = pointer.getLayoutX() - imageView.getLayoutX();
           double y = pointer.getLayoutY() - imageView.getLayoutY();
           distance = Math.pow(x,2)+Math.pow(y,2);
           if(minDistance>distance)
           {
               minDistance = distance;
                target = pointer;
           }
       }
        building = (Building) target.getImage();

    }
}
