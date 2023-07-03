package com.example.finalgame.map;

import com.example.finalgame.HelloApplication;
import com.example.finalgame.building.Building;
import com.example.finalgame.building.DeathStar;
import com.example.finalgame.building.FloatingCastle;
import com.example.finalgame.building.UFO;
import com.example.finalgame.drag.Draggable;
import com.example.finalgame.hero.DarthVader;
import com.example.finalgame.hero.Dragon;
import com.example.finalgame.hero.StormTrooper;
import com.example.finalgame.hero.Witch;
import com.example.finalgame.pages.AllHeroes;
import com.example.finalgame.thread.BuildingsAttack;
import com.example.finalgame.thread.MovingHeroes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Map3 extends Map implements Initializable {

    @FXML
    private AnchorPane ancherPane;

    @FXML
    private ImageView backGround;

    @FXML
    private ImageView castleImage;

    @FXML
    private ImageView ufoImage1;

    @FXML
    private ImageView ufoImage2;

    @FXML
    private ImageView deathStar;
     private static Map3 map3;
    public   Map3() {
        super(3);
    }
    public static Map3 getMap3()
    {
        if(map3==null)
            map3 = new Map3();
        return map3;
    }
    @FXML
    private Button heroBtn;

    @FXML
    private Button startBtn;

    @FXML
    private Button backBtn;
    @FXML
   public ImageView imageView;
    @FXML
    private ImageView blueRay; //**************************************************
    @FXML
    private ImageView ufoRay2;

    @FXML
    private ImageView ufoRay1;
    //=========================================Thread============================================================
    private BuildingsAttack attack ;
    private BuildingsAttack attack2;
    private BuildingsAttack attack3;
    //============================================================================================================
   public static ArrayList<Thread> threads = new ArrayList<>();
   public static ArrayList<ImageView>buildings = new ArrayList<>();
    @FXML
    void arrangeHeroes(ActionEvent event) {
        for(int i = 0; i< AllHeroes.getStormCounter(); i++){
            imageView = new ImageView();
            StormTrooper stormTrooper = new StormTrooper();
            imageView.setImage(stormTrooper);
            MovingHeroes movingHeroes = new MovingHeroes(imageView,stormTrooper,this.buildings);
            threads.add(movingHeroes);
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            imageView.setLayoutX(0);
            imageView.setLayoutY(0);
            HelloApplication.root.getChildren().add(imageView);
            Draggable.makeDraggable(imageView);
        }
        for(int i = 0;i<AllHeroes.getDarthCounter();i++){
            imageView = new ImageView();
            DarthVader darthVader = new DarthVader();
            imageView.setImage(darthVader);
            MovingHeroes movingHeroes = new MovingHeroes(imageView,darthVader,this.buildings);
            threads.add(movingHeroes);
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            imageView.setLayoutX(100);
            imageView.setLayoutY(100);
            HelloApplication.root.getChildren().add(imageView);
            Draggable.makeDraggable(imageView);
        }
        for(int i = 0;i<AllHeroes.getDragonCounter();i++){
            imageView = new ImageView();
            Dragon dragon = new Dragon();
            imageView.setImage(dragon);
            MovingHeroes movingHeroes = new MovingHeroes(imageView,dragon,this.buildings);
            threads.add(movingHeroes);
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            imageView.setLayoutX(200);
            imageView.setLayoutY(200);
            HelloApplication.root.getChildren().add(imageView);
            Draggable.makeDraggable(imageView);
        }
        for(int i = 0;i<AllHeroes.getWitchCounter();i++){
            imageView = new ImageView();
            Witch witch = new Witch();
            imageView.setImage(witch);
            MovingHeroes movingHeroes = new MovingHeroes(imageView,witch,this.buildings);
            threads.add(movingHeroes);
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            imageView.setLayoutX(300);
            imageView.setLayoutY(300);
            HelloApplication.root.getChildren().add(imageView);
            Draggable.makeDraggable(imageView);
        }
    }

    @FXML
    void back(ActionEvent event) {

    }

    @FXML
    void start(ActionEvent event) {
        for(Thread pointer : threads)
            {
                pointer.start();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("*");
            }

        attack.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        attack2.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        attack3.start();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FloatingCastle floatingCastle = new FloatingCastle();
        //castleImage = new ImageView(); //**************************************************************
        //  1.set images of buildings2. making thread for buildings 3.adding buildings to a list
        castleImage.setImage(floatingCastle);
        UFO ufo = new UFO();
        ufoImage1.setImage(ufo);
        UFO ufo2 = new UFO();
        ufoImage2.setImage(ufo2);
        DeathStar deathStar1 = new DeathStar();
        deathStar.setImage(deathStar1);
        //****************************
        getBuildings().add(ufo2);
        getBuildings().add(ufo);
        getBuildings().add(deathStar1);
        getBuildings().add(floatingCastle);
        //****************************
         buildings.add(ufoImage2);
        buildings.add(ufoImage1);
        buildings.add(deathStar);
        buildings.add(castleImage);
        //*******************************
        attack = new BuildingsAttack(deathStar1,blueRay);
        attack2 = new BuildingsAttack(ufo,ufoRay1);
        attack3 = new BuildingsAttack(ufo2,ufoRay2);


    }
}

