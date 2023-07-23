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
import com.example.finalgame.thread.MovingHeroes;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;

public class Map4 extends Map implements Initializable {

    @FXML
    private AnchorPane ancherPane;
    @FXML
    private Text determinationTxt = new Text();
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
    public static ArrayList<Thread> threads = new ArrayList<>();
    public static ArrayList<ImageView>buildings = new ArrayList<>();
    public static ArrayList<ImageView>heroes = new ArrayList<>();
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
                }
            }
        },0,1000);
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
        attack1 = new BuildingsAttack(canon,blackBall1,heroes);
        attack2 = new BuildingsAttack(canon1,blackBall2,heroes);
        attack3 = new BuildingsAttack(canon2,blackBall3,heroes);
        attack4 = new BuildingsAttack(sandCastle1,blackBall4,heroes);
        //*************************************
        buildings.add(sandCastle);
        buildings.add(canonImage1);
        buildings.add(canonImage2);
        buildings.add(canonImage3);
    }
}

