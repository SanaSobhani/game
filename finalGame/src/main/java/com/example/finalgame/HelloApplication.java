package com.example.finalgame;

import com.example.finalgame.hero.DarthVader;
import com.example.finalgame.hero.Dragon;
import com.example.finalgame.hero.StormTrooper;
import com.example.finalgame.hero.Witch;
import com.example.finalgame.map.Map;
import com.example.finalgame.player.Player;
import com.example.finalgame.player.PlayerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import com.example.finalgame.map.*;
public class HelloApplication extends Application {
    ArrayList<Player>players = new ArrayList<>();
    ArrayList<Map> maps;
    public static Pane root = new Pane();
    private static Stage stg;
    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        root = FXMLLoader.load(getClass().getResource("firstPage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void changeScene(String fxml) throws IOException {
        root = FXMLLoader.load(getClass().getResource(fxml));
        stg.setScene(new Scene(root));
        stg.show();
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // PlayerController.setPassWord("12345678");
        //MapController.setMapPointer(new Map1());
        launch();
       // Player player = new Player("man1234","12345678");

    }
}