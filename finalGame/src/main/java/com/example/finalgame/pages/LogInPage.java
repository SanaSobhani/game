package com.example.finalgame.pages;

import com.example.finalgame.player.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.sql.SQLException;

public class LogInPage {

    @FXML
    private AnchorPane ancherPane;

    @FXML
    private ImageView backGround;

    @FXML
    private Text titleTxt;

    @FXML
    private PasswordField passWordField;

    @FXML
    private Text passWordTxt;

    @FXML
    private Button logInButton;
    @FXML
    private Text errorTxt;
    @FXML
    void logIn(ActionEvent event) throws SQLException {
        if(!Player.logIn(passWordField.getText()))
            errorTxt.setText("please sign up");
        else
            System.out.println("t");
    }

}
