package com.example.finalgame.thread;

import com.example.finalgame.building.Building;
import com.example.finalgame.hero.*;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;

public class MovingHeroes extends Thread{
    private ImageView imageView;
    private Hero hero;
    private ArrayList<ImageView>buildings = new ArrayList<>();
    private ImageView target;
   public MovingHeroes(ImageView imageView, Hero hero,ArrayList<ImageView>buildings){
        this.imageView= new ImageView();
        this.hero = hero;
        this.imageView = imageView;
        this.buildings = buildings;
    }
    @Override
    public void run(){
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(imageView);
        findingClosest();
        if(hero instanceof Dragon) {
            transition.setDuration(Duration.millis(500));
            transition.setToX(target.getLayoutX());
            transition.setToY(200);
        }
        if(hero instanceof Witch){
            transition.setDuration(Duration.millis(900));
            transition.setToX(target.getLayoutX()+110);
            transition.setToY(target.getLayoutY()+20);
        }
        if(hero instanceof DarthVader)
        {
            transition.setDuration(Duration.seconds(1));
            transition.setToX(target.getLayoutX()+100);
            transition.setToY(target.getLayoutY()+20);
        }
        if(hero instanceof StormTrooper ){
            transition.setDuration(Duration.seconds(1.5));
            System.out.println("lay out"+target.getLayoutX());
            System.out.println("x"+target.getX());
            System.out.println("translate "+target.getTranslateX());
            transition.setToX((target.getLayoutX()+120));
            transition.setToY(target.getLayoutY()+20);
        }
        transition.play();
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
