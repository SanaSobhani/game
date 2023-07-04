package com.example.finalgame.pages;

import com.example.finalgame.HelloApplication;
import com.example.finalgame.map.*;
import com.example.finalgame.player.PlayerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class AllHeroes implements Initializable {

    @FXML
    private Button witch;

    @FXML
    private ImageView witchImg;

    @FXML
    private Button stormTrooper;

    @FXML
    private Button darthVader;

    @FXML
    private Button dragon;

    @FXML
    private ImageView stormImg;

    @FXML
    private ImageView darthImg;

    @FXML
    private ImageView dragonImg;

    @FXML
    private Text txt1;

    @FXML
    private Text txt6;

    @FXML
    private Text txt2;

    @FXML
    private Text txt7;

    @FXML
    private Text txt3;

    @FXML
    private Text txt8;

    @FXML
    private Text txt5;

    @FXML
    private Text txt10;

    @FXML
    private Text txt4;

    @FXML
    private Text txt9;

    @FXML
    private Text selectionTxt1;

    @FXML
    private Text selectionTxt2;

    @FXML
    private Text selectionTxt3;

    @FXML
    private Text selectionTxt4;
    private Alert alert = new Alert(Alert.AlertType.ERROR);
    @FXML
    private Text txt11;
    @FXML
    private Text enemy;
    @FXML
    private Button nextBtn;
   private static int witchCounter =0;
   private static int dragonCounter =0;
   private static int stormCounter =0;
   private static int darthCounter =0;
   //------------------------------------------------------------------------------------------
    public static int getWitchCounter() {
        return witchCounter;
    }

    public static void setWitchCounter(int witchCounter) {
        AllHeroes.witchCounter = witchCounter;
    }

    public static int getDragonCounter() {
        return dragonCounter;
    }

    public static void setDragonCounter(int dragonCounter) {
        AllHeroes.dragonCounter = dragonCounter;
    }

    public static int getStormCounter() {
        return stormCounter;
    }

    public static void setStormCounter(int stormCounter) {
        AllHeroes.stormCounter = stormCounter;
    }

    public static int getDarthCounter() {
        return darthCounter;
    }

    public static void setDarthCounter(int darthCounter) {
        AllHeroes.darthCounter = darthCounter;
    }
    //-------------------------------------------------------------------------------------------------------
    @FXML
    void chooseDarthVader(ActionEvent event) {
        if(MapController.getMapPointer() instanceof Map1 || MapController.getMapPointer() instanceof Map3 || PlayerController.getPointer().getLevel()<5)
        {
            alert.setTitle("Alert!!!");
            alert.setContentText("you cant select this hero");
            Optional<ButtonType> result = alert.showAndWait();
        }
        else {
            darthCounter++;
            selectionTxt3.setText("selected");
        }
    }

    @FXML
    void chooseDragon(ActionEvent event) {
        dragonCounter++;
        selectionTxt4.setText("selected");
    }

    @FXML
    void chooseStorm(ActionEvent event) {
        stormCounter++;
        selectionTxt2.setText("selected");
    }

    @FXML
    void chooseWitch(ActionEvent event) {
        witchCounter++;
        selectionTxt1.setText("selected");
    }

    @FXML
    void next(ActionEvent event) throws IOException {
        if(MapController.getMapPointer() instanceof Map1)
            new HelloApplication().changeScene("map1.fxml");
        if(MapController.getMapPointer() instanceof Map2)
            new HelloApplication().changeScene("map2.fxml");
        if(MapController.getMapPointer() instanceof Map3)
            new HelloApplication().changeScene("map3.fxml");
        if(MapController.getMapPointer() instanceof Map4)
            new HelloApplication().changeScene("map4.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.enemy = new Text();
        if(MapController.getMapPointer() instanceof Map1)
            enemy.setText("attack to map1");
        if(MapController.getMapPointer() instanceof Map2)
            enemy.setText("attack to map2");
        if(MapController.getMapPointer() instanceof Map3)
            enemy.setText("attack to map3");
        if(MapController.getMapPointer() instanceof Map4)
            enemy.setText("attack to map4");
    }
}
