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
import com.example.finalgame.player.Player;
import com.example.finalgame.player.PlayerController;
import com.example.finalgame.thread.BuildingsAttack;
import com.example.finalgame.thread.MovingHeroes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

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
    private ImageView blueRay2;

    @FXML
    private ImageView blueRay1;

    @FXML
    private ImageView redBall;
    @FXML
    private Text determinationTxt = new Text();
    //======================================Thread==========================================
    private BuildingsAttack attack;
    private BuildingsAttack attack2;
    private BuildingsAttack attack3;
    //=========================================================================================
    public static ArrayList<Thread> threads = new ArrayList<>();
    public static ArrayList<ImageView>buildings = new ArrayList<>();
    public static ArrayList<ImageView> heroes = new ArrayList<>();
    void arrangeHeroes(ActionEvent event) {
        for(int i = 0; i< AllHeroes.getStormCounter(); i++){
            imageView = new ImageView();
            heroes.add(imageView);
            StormTrooper stormTrooper = new StormTrooper();
            imageView.setImage(stormTrooper);
            ImageView fireView = new ImageView();
            fireView.setImage(stormTrooper.getFire());
            fireView.setFitWidth(69);
            fireView.setFitHeight(41);
            MovingHeroes movingHeroes = new MovingHeroes(imageView,stormTrooper,this.buildings,fireView);
            threads.add(movingHeroes);
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            imageView.setLayoutX(100);
            imageView.setLayoutY(100);
            HelloApplication.root.getChildren().add(imageView);
            Draggable.makeDraggable(imageView);
            HelloApplication.root.getChildren().add(fireView);
            fireView.setLayoutY(imageView.getLayoutY()+30);
            fireView.setLayoutX(imageView.getLayoutX()-79);
        }
        for(int i = 0;i<AllHeroes.getDarthCounter();i++){
            imageView = new ImageView();
            heroes.add(imageView);
            DarthVader darthVader = new DarthVader();
            imageView.setImage(darthVader);
            ImageView fireView = new ImageView();
            fireView.setImage(darthVader.getFire());
            fireView.setFitWidth(69);
            fireView.setFitHeight(41);
            MovingHeroes movingHeroes = new MovingHeroes(imageView,darthVader,this.buildings,fireView);
            threads.add(movingHeroes);
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            imageView.setLayoutX(100);
            imageView.setLayoutY(100);
            HelloApplication.root.getChildren().add(imageView);
            Draggable.makeDraggable(imageView);
            HelloApplication.root.getChildren().add(fireView);
            fireView.setLayoutY(imageView.getLayoutY()+62);
            fireView.setLayoutX(imageView.getLayoutX()-79);
        }
        for(int i = 0;i<AllHeroes.getDragonCounter();i++){
            imageView = new ImageView();
            heroes.add(imageView);
            Dragon dragon = new Dragon();
            imageView.setImage(dragon);
            ImageView fireView = new ImageView(dragon.getFire());
            fireView.setFitWidth(69);
            fireView.setFitHeight(41);
            MovingHeroes movingHeroes = new MovingHeroes(imageView,dragon,this.buildings,fireView);
            threads.add(movingHeroes);
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            imageView.setLayoutX(200);
            imageView.setLayoutY(200);
            HelloApplication.root.getChildren().add(imageView);
            Draggable.makeDraggable(imageView);
            HelloApplication.root.getChildren().add(fireView);
            fireView.setLayoutY(imageView.getLayoutY()+57);
            fireView.setLayoutX(imageView.getLayoutX()+76);
        }
        for(int i = 0;i<AllHeroes.getWitchCounter();i++){
            imageView = new ImageView();
            heroes.add(imageView);
            Witch witch = new Witch();
            imageView.setImage(witch);
            ImageView fireView = new ImageView();//***********************
            fireView.setImage(witch.getFire());
            fireView.setFitWidth(69);
            fireView.setFitHeight(41);
            MovingHeroes movingHeroes = new MovingHeroes(imageView,witch,this.buildings,fireView);
            threads.add(movingHeroes);
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            imageView.setLayoutX(300);
            imageView.setLayoutY(300);
            HelloApplication.root.getChildren().add(imageView);
            Draggable.makeDraggable(imageView);
            HelloApplication.root.getChildren().add(fireView);
            fireView.setLayoutY(imageView.getLayoutY()+62);
            fireView.setLayoutX(imageView.getLayoutX()-79);
        }

    }

    @FXML
    void back(ActionEvent event) {
        try {
            new HelloApplication().changeScene("allHeroes.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
        //****************** determination *******************
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(heroes.size()==0) {
                    determinationTxt.setText("You lost");
                }
                if(buildings.size()==0){
                    determinationTxt.setText("You won");
                    /*PlayerController.getPointer().setLevel(PlayerController.getPointer().getLevel()+1);
                    try {
                        Player.dataBase.saveLevelToDataBase(PlayerController.getPointer().getLevel());
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }*/
                }
            }
        },0,1000);
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
        //*******************************
        getBuildings().add(watchTower1);
        getBuildings().add(deathStar3);
        getBuildings().add(deathStar);
        //****************************
        attack = new BuildingsAttack(watchTower1,redBall,heroes);
        attack2 = new BuildingsAttack(deathStar3,blueRay2,heroes);
        attack3 = new BuildingsAttack(deathStar,blueRay1,heroes);
        //*******************************
        buildings.add(deathStar1);
        buildings.add(deathStar2);
        buildings.add(watchTower);
    }
}

