package application.controller;

import application.ServiceLocator;
import application.database.PlayerService;
import application.model.player.Player;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInController {

    private static PlayerService playerService;

    private void init(){
        playerService = ServiceLocator.getService(PlayerService.class);
    }

    public void changeToSignUp(ActionEvent event) throws IOException{

        Stage prevStage = (Stage) signUpButton.getScene().getWindow();

        Stage stage = new Stage();
        stage.setTitle("Sign up");
        Pane myPane = null;

        myPane = FXMLLoader.load(getClass().getResource("/views/SignUpPage.fxml"));
        Scene scene = new Scene(myPane);

        stage.setScene(scene);

        prevStage.close();

        stage.show();

    }

    public void changeToLoggedIn(ActionEvent event) throws IOException{

        Stage prevStage = (Stage) signInButton.getScene().getWindow();

        Stage stage = new Stage();
        stage.setTitle("Logged In");
        Pane myPane = null;

        myPane = FXMLLoader.load(getClass().getResource("/views/LoggedInPage.fxml"));
        Scene scene = new Scene(myPane);

        stage.setScene(scene);

        prevStage.close();

        stage.show();

    }

    @FXML
    private JFXTextField userNameField;

    @FXML
    private JFXButton quitButton;

    @FXML
    private JFXButton signUpButton;

    @FXML
    private JFXPasswordField passwordField;

    @FXML
    private JFXButton signInButton;

    @FXML
    void onClickedSignInButton(ActionEvent event) throws  IOException{
        init();

        for(Player player: playerService.findAllPlayer()){
            if(userNameField.getText().equals(player.getUserName()) && passwordField.getText().equals(player.getPassword())){
                changeToLoggedIn(event);
            }
        }

    }

    @FXML
    void onClickedSignUpButton(ActionEvent event) throws IOException{

        changeToSignUp(event);
        SignUpController.init();

    }

    @FXML
    void onClickedQuitButton(ActionEvent event) throws IOException{

        Stage stage = (Stage) quitButton.getScene().getWindow();

        stage.close();

    }

}
