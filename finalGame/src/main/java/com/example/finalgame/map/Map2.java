package com.example.finalgame.map;

import com.example.finalgame.building.Canon;
import com.example.finalgame.building.OldCastle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
        getBuildings().add(oldCastle);
        getBuildings().add(canon1);
        getBuildings().add(canon2);
        getBuildings().add(canon3);
    }
}
