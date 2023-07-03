package com.example.finalgame.map;

import com.example.finalgame.HelloApplication;
import com.example.finalgame.building.Canon;
import com.example.finalgame.building.SandCastle;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;

public class Map4 extends Map implements Initializable {

    @FXML
    private AnchorPane ancherPane;

    @FXML
    private ImageView backGround;

    @FXML
    private ImageView sodier;

    @FXML
    private ImageView sandCastle;

    @FXML
    private ImageView canonImage2;

    @FXML
    private ImageView canonImage1;

    @FXML
    private ImageView canonImage3;
    @FXML
    private Button heroBtn;

    @FXML
    private Button startBtn;
    @FXML
    private ImageView imageView ;
    @FXML
    private Button backBtn;
    @FXML
    private ImageView blackBall4;

    @FXML
    private ImageView blackBall3;

    @FXML
    private ImageView blackBall1;

    @FXML
    private ImageView blackBall2;
    //=============================Thread==============================================
    BuildingsAttack attack1 ;
    BuildingsAttack attack2;
    BuildingsAttack attack3;
    BuildingsAttack attack4;
    //====================================================================================
    private static Map4 map4;
    public  Map4() {
        super(4);
    }
    public static Map4 getMap4()
    {
        if(map4==null)
            map4 = new Map4();
        return map4;
    }
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
    void start(ActionEvent event) {
        attack1.start();
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
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        attack4.start();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Canon canon = new Canon();
        canonImage1.setImage(canon);
        Canon canon1 = new Canon();
        canonImage2.setImage(canon1);
        Canon canon2 = new Canon();
        canonImage3.setImage(canon2);
        SandCastle sandCastle1 = new SandCastle();
        sandCastle.setImage(sandCastle1);
        //*********************************
        getBuildings().add(canon1);
        getBuildings().add(canon);
        getBuildings().add(canon2);
        getBuildings().add(sandCastle1);
        //**********************************
        attack1 = new BuildingsAttack(canon,blackBall1);
        attack2 = new BuildingsAttack(canon1,blackBall2);
        attack3 = new BuildingsAttack(canon2,blackBall3);
        attack4 = new BuildingsAttack(sandCastle1,blackBall4);
    }
}

