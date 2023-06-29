package com.example.finalgame.map;

import com.example.finalgame.building.Canon;
import com.example.finalgame.building.SandCastle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
        getBuildings().add(canon1);
        getBuildings().add(canon);
        getBuildings().add(canon2);
        getBuildings().add(sandCastle1);
    }
}

