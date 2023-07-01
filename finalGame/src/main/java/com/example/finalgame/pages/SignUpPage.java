package com.example.finalgame.pages;

import com.example.finalgame.player.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

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
            msgTxt.setText("you are signed up");
        }
        catch (SQLException exception){errorTxt.setText("not successful");}
    }

}
