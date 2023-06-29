package com.example.finalgame.map;

import com.example.finalgame.building.Building;
import com.example.finalgame.building.DeathStar;
import com.example.finalgame.building.FloatingCastle;
import com.example.finalgame.building.UFO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FloatingCastle floatingCastle = new FloatingCastle();
        castleImage.setImage(floatingCastle);
        UFO ufo = new UFO();
        ufoImage1.setImage(ufo);
        UFO ufo2 = new UFO();
        ufoImage2.setImage(ufo2);
        DeathStar deathStar1 = new DeathStar();
        deathStar.setImage(deathStar1);
        getBuildings().add(ufo2);
        getBuildings().add(ufo);
        getBuildings().add(deathStar1);
    }
}

