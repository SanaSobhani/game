package com.example.finalgame.map;

import com.example.finalgame.building.Building;
import com.example.finalgame.building.DeathStar;
import com.example.finalgame.building.WatchTower;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private ImageView deathStar2;

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
    }
}

