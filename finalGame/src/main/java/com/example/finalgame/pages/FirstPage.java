package com.example.finalgame.pages;

import com.example.finalgame.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class FirstPage {

    @FXML
    private ImageView starsLogo;

    @FXML
    private ImageView clashLogo;

    @FXML
    private Button sigUpButton;

    @FXML
    private Button logInButton;

    @FXML
    void logIn(ActionEvent event){
        try {
            new HelloApplication().changeScene("logINPage.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void signUp(ActionEvent event) {

        try {
            new HelloApplication().changeScene("SignUpPage.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
