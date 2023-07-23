package com.example.finalgame.map;

import com.example.finalgame.HelloApplication;
import com.example.finalgame.building.Canon;
import com.example.finalgame.building.OldCastle;
import com.example.finalgame.drag.Draggable;
import com.example.finalgame.hero.*;
import com.example.finalgame.pages.AllHeroes;
import com.example.finalgame.thread.BuildingsAttack;
import com.example.finalgame.thread.MovingHeroes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

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
    private Text determinationTxt = new Text();
    @FXML
    private ImageView canonImage2;

    @FXML
    private ImageView canonImage3;
    @FXML
    private ImageView imageView;
    private static Map2 map2;
    public   Map2() {
        super(2);
    }
    @FXML
    private Button heroBtn;

    @FXML
    private Button startBtn;

    @FXML
    private Button backBtn;
    @FXML
    private ImageView blackBall2;

    @FXML
    private ImageView blackBall1;

    @FXML
    private ImageView blackBall3;
    //==================================Thread==========================================
    private BuildingsAttack attack ;
    private BuildingsAttack attack2;
    private BuildingsAttack attack3;
    //=================================================================================
    public static ArrayList<Thread> threads = new ArrayList<>();
    public static ArrayList<ImageView>buildings = new ArrayList<>();
    public static ArrayList<ImageView>heroes = new ArrayList<>();
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
    void start(ActionEvent event){
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
                }
            }
        },0,1000);
    }
    public static Map2 getMap2()
    {
        if(map2==null)
            map2 = new Map2();
        return map2;
    }

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
        //********************************
        getBuildings().add(oldCastle);
        getBuildings().add(canon1);
        getBuildings().add(canon2);
        getBuildings().add(canon3);
        //**********************************
        attack = new BuildingsAttack(canon1,blackBall1,heroes);
        attack2 = new BuildingsAttack(canon2,blackBall2,heroes);
        attack3 = new BuildingsAttack(canon3,blackBall3,heroes);
        //***********************************
        buildings.add(canonImage1);
        buildings.add(canonImage3);
        buildings.add(canonImage2);
        buildings.add(castleImg);
    }
}
