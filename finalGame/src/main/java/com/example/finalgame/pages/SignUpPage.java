package com.example.finalgame.pages;

import com.example.finalgame.HelloApplication;
import com.example.finalgame.player.Player;
import com.example.finalgame.player.PlayerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.SQLException;

public class SignUpPage {

    @FXML
    private AnchorPane ancherPane;

    @FXML
    private ImageView backGround;

    @FXML
    private TextField idField;

    @FXML
    private Text IDTxt;

    @FXML
    private Text passWordTxt;

    @FXML
    private PasswordField passWordField;

    @FXML
    private Button signUpButton;

    @FXML
    private Text titleTxt;

    @FXML
    private Text errorTxt;

    @FXML
    private Text msgTxt;

    @FXML
    void signUp(ActionEvent event) throws ClassNotFoundException {
        try {
            Player player = new Player(idField.getText(),passWordField.getText());
            PlayerController.setPointer(player);
            msgTxt.setText("you are signed up");
            //********* set level of player**********
            player.setLevel((int)(Math.random())*(10-1)+1);
            //Player.dataBase.saveLevelToDataBase(player.getLevel());
            //***************************************
            try {
                new HelloApplication().changeScene("logInPage.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        catch (SQLException exception){errorTxt.setText("not successful");
            System.out.println(exception.getMessage());}
    }

}
