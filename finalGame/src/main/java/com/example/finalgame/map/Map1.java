package com.example.finalgame.map;

import com.example.finalgame.HelloApplication;
import com.example.finalgame.building.Building;
import com.example.finalgame.building.DeathStar;
import com.example.finalgame.building.WatchTower;
import com.example.finalgame.drag.Draggable;
import com.example.finalgame.hero.DarthVader;
import com.example.finalgame.hero.Dragon;
import com.example.finalgame.hero.StormTrooper;
import com.example.finalgame.hero.Witch;
import com.example.finalgame.pages.AllHeroes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Map1 extends Map implements Initializable {

    @FXML
    private AnchorPane ancherPane;

    @FXML
    private ImageView backGround;

    @FXML
    private ImageView soldier;

    @FXML
    private ImageView watchTower;

    @FXML
    private ImageView deathStar1;
    @FXML
    private ImageView imageView;
    @FXML
    private ImageView deathStar2;
    private static Map1 map1;
    public   Map1() {
        super(1);
    }
    @FXML
    private Button heroBtn;

    @FXML
    private Button startBtn;

    @FXML
    private Button backBtn;

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

    }
    public static Map1 getMap1()
    {
        if(map1==null)
             map1 = new Map1();
        return map1;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        WatchTower watchTower1 = new WatchTower();
        watchTower.setImage(watchTower1);
        DeathStar deathStar = new DeathStar();
        deathStar1.setImage(deathStar);
        DeathStar deathStar3 = new DeathStar();
        deathStar2.setImage(deathStar3);
        getBuildings().add(watchTower1);
        getBuildings().add(deathStar3);
        getBuildings().add(deathStar);
        System.out.println(this.getId());
    }
}

