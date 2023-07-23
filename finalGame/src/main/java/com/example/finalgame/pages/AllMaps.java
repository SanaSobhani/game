package com.example.finalgame.pages;

import com.example.finalgame.HelloApplication;
import com.example.finalgame.map.*;
import com.example.finalgame.player.Player;
import com.example.finalgame.player.PlayerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.SQLException;

public class AllMaps {

    @FXML
    private AnchorPane ancherPane;

    @FXML
    private ImageView backGround;

    @FXML
    private Text titleTxt;

    @FXML
    private ImageView map2;

    @FXML
    private ImageView map1;

    @FXML
    private ImageView map3;

    @FXML
    private ImageView map4;

    @FXML
    private Text defensiveTxt;

    @FXML
    private Text non_defensiveTxt;

    @FXML
    private Text number4;

    @FXML
    private Text number3;

    @FXML
    private Text number2;

    @FXML
    private Text numberr1;

    @FXML
    private Text number5;

    @FXML
    private Text number6;

    @FXML
    private Text number7;

    @FXML
    private Text number8;

    @FXML
    private Button selectButton1;

    @FXML
    private Button selectButton2;

    @FXML
    private Button selectButton3;

    @FXML
    void selection1(ActionEvent event){
        try {
            Player.dataBase.saveMapToDataBase(Map2.getMap2().getId(), PlayerController.getPassWord());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        makeAnEnemy();
        try {
            new HelloApplication().changeScene("allHeroes.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void selection2(ActionEvent event){
        try {
            Player.dataBase.saveMapToDataBase(Map3.getMap3().getId(), PlayerController.getPassWord());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        makeAnEnemy();
        try {
            new HelloApplication().changeScene("allHeroes.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void selection3(ActionEvent event) {
        try {
            Player.dataBase.saveMapToDataBase(Map4.getMap4().getId(), PlayerController.getPassWord());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        makeAnEnemy();
        try {
            new HelloApplication().changeScene("allHeroes.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void selection4(ActionEvent event) throws SQLException {
        Player.dataBase.saveMapToDataBase(Map1.getMap1().getId(), PlayerController.getPassWord());
        makeAnEnemy();
        try {
            new HelloApplication().changeScene("allHeroes.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void makeAnEnemy()  {
        int randomMap =  (int)((Math.random()*(4-1))+1);
        if(randomMap==1)
             MapController.setMapPointer(new Map1());
        if(randomMap==2)
            MapController.setMapPointer(new Map2());
        if(randomMap==3)
            MapController.setMapPointer(new Map3());
        if(randomMap==4)
            MapController.setMapPointer(new Map4());
    }
}
