package com.example.finalgame.map;

import com.example.finalgame.HelloApplication;
import com.example.finalgame.building.Canon;
import com.example.finalgame.building.OldCastle;
import com.example.finalgame.drag.Draggable;
import com.example.finalgame.hero.DarthVader;
import com.example.finalgame.hero.Dragon;
import com.example.finalgame.hero.StormTrooper;
import com.example.finalgame.hero.Witch;
import com.example.finalgame.pages.AllHeroes;
import com.example.finalgame.thread.BuildingsAttack;
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

public class Map2 extends Map implements Initializable {

    @FXML
    private AnchorPane ancherPane;

    @FXML
    private ImageView backGround;

    @FXML
    private ImageView castleImg;

    @FXML
    private ImageView canonImage1;

    @FXML
    private ImageView canonImage2;

    @FXML
    private ImageView canonImage3;
    @FXML
    private ImageView imageView;
    private static Map2 map2;
    public   Map2() {
        super(2);
    }
    @FXML
    private Button heroBtn;

    @FXML
    private Button startBtn;

    @FXML
    private Button backBtn;
    @FXML
    private ImageView blackBall2;

    @FXML
    private ImageView blackBall1;

    @FXML
    private ImageView blackBall3;
    //==================================Thread==========================================
    private BuildingsAttack attack ;
    private BuildingsAttack attack2;
    private BuildingsAttack attack3;
    //=================================================================================

    @FXML
    void arrangeHeroes(ActionEvent event) {
        for(int i = 0; i< AllHeroes.getStormCounter(); i++){
            imageView = new ImageView();
            imageView.setImage(new StormTrooper());
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            imageView.setLayoutX(0);
            imageView.setLayoutY(0);
            HelloApplication.root.getChildren().add(imageView);
            Draggable.makeDraggable(imageView);
        }
        for(int i = 0;i<AllHeroes.getDarthCounter();i++){
            imageView = new ImageView();
            imageView.setImage(new DarthVader());
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            imageView.setLayoutX(100);
            imageView.setLayoutY(100);
            HelloApplication.root.getChildren().add(imageView);
            Draggable.makeDraggable(imageView);
        }
        for(int i = 0;i<AllHeroes.getDragonCounter();i++){
            imageView = new ImageView();
            imageView.setImage(new Dragon());
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            imageView.setLayoutX(200);
            imageView.setLayoutY(200);
            HelloApplication.root.getChildren().add(imageView);
            Draggable.makeDraggable(imageView);
        }
        for(int i = 0;i<AllHeroes.getWitchCounter();i++){
            imageView = new ImageView();
            imageView.setImage(new Witch());
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
    void start(ActionEvent event){
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
    public static Map2 getMap2()
    {
        if(map2==null)
            map2 = new Map2();
        return map2;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Canon canon1 = new Canon();
        canonImage1.setImage(canon1);
        Canon canon2 = new Canon();
        canonImage2.setImage(canon2);
        Canon canon3 = new Canon();
        canonImage3.setImage(canon3);
        OldCastle oldCastle = new OldCastle();
        castleImg.setImage(oldCastle);
        //********************************
        getBuildings().add(oldCastle);
        getBuildings().add(canon1);
        getBuildings().add(canon2);
        getBuildings().add(canon3);
        //**********************************
        attack = new BuildingsAttack(canon1,blackBall1);
        attack2 = new BuildingsAttack(canon2,blackBall2);
        attack3 = new BuildingsAttack(canon3,blackBall3);
    }
}
