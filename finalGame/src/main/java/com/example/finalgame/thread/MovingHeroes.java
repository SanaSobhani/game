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

public class MovingHeroes extends Thread{
    private ImageView imageView;
    private Hero hero;
    private ArrayList<ImageView>buildings = new ArrayList<>();
    private ImageView target;
    private ImageView fire;
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
            TranslateTransition fireTransition = new TranslateTransition();
            fireTransition.setNode(fire);
            fireTransition.setByX(200);
            fireTransition.setByY(200);
            fireTransition.setCycleCount(100);
            fireTransition.play();
        }
        if(hero instanceof Witch){
            imageView.setLayoutX(target.getLayoutX()+110);
            imageView.setLayoutY(target.getLayoutY()-90);
            fire.setLayoutY(imageView.getLayoutY()+60);
            fire.setLayoutX(imageView.getLayoutX()-50);
            TranslateTransition fireTransition = new TranslateTransition();
            fireTransition.setNode(fire);
            fireTransition.setByX(-200);
            fireTransition.setByY(100);
            fireTransition.setCycleCount(100);
            fireTransition.play();
        }
        if(hero instanceof DarthVader)
        {
            imageView.setLayoutX(target.getLayoutX()+200);
            imageView.setLayoutY(target.getLayoutY()-70);
            fire.setLayoutY(imageView.getLayoutY()+60);
            fire.setLayoutX(imageView.getLayoutX()-50);
            TranslateTransition fireTransition = new TranslateTransition();
            fireTransition.setNode(fire);
            fireTransition.setByX(-200);
            fireTransition.setByY(0);
            fireTransition.setCycleCount(100);
            fireTransition.play();
        }
        if(hero instanceof StormTrooper ){
            imageView.setLayoutX(target.getLayoutX()+90);
            imageView.setLayoutY(target.getLayoutY()-90);
            fire.setLayoutY(imageView.getLayoutY()+30);
            fire.setLayoutX(imageView.getLayoutX()-62);
            TranslateTransition fireTransition = new TranslateTransition();
            fireTransition.setNode(fire);
            fireTransition.setByX(-100);
            fireTransition.setByY(0);
            fireTransition.setCycleCount(100);
            fireTransition.play();
        }
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
    }
}
