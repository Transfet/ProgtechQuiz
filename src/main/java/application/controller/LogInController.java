package application.controller;

import application.Game;
import application.ServiceLocator;
import application.database.PlayerService;
import application.model.player.Player;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogInController implements Initializable {

    private static PlayerService playerService;

    Logger logger = LoggerFactory.getLogger(LogInController.class);

    @FXML
    private AnchorPane anchorPane;

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

    private void init() {
        playerService = ServiceLocator.getService(PlayerService.class);
    }

    private void changeToSignUp(ActionEvent event) throws IOException {

        Stage prevStage = (Stage) signUpButton.getScene().getWindow();

        Stage stage = new Stage();
        stage.setTitle("Sign up");
        Pane myPane;

        myPane = FXMLLoader.load(getClass().getResource("/views/SignUpPage.fxml"));
        Scene scene = new Scene(myPane);

        stage.setScene(scene);

        prevStage.close();

        stage.show();

    }

    private void changeToLoggedIn(ActionEvent event) throws IOException {

        Stage prevStage = (Stage) signInButton.getScene().getWindow();

        Stage stage = new Stage();
        stage.setTitle("Logged In");
        Pane myPane;

        myPane = FXMLLoader.load(getClass().getResource("/views/LoggedInPage.fxml"));
        Scene scene = new Scene(myPane);

        stage.setScene(scene);
        prevStage.close();

        stage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (!Game.isSplashLoaded)
            loadSplashScreen();
    }

    private void loadSplashScreen() {
        try {
            Game.isSplashLoaded = true;

            AnchorPane pane = FXMLLoader.load(getClass().getResource("/views/Splash.fxml"));
            anchorPane.getChildren().setAll(pane);

            FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), pane);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(1);

            FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), pane);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setCycleCount(1);

            fadeIn.play();

            fadeIn.setOnFinished((e) -> fadeOut.play());

            fadeOut.setOnFinished((e) -> fadeOutFinished());

        } catch (IOException e) {
            logger.error("Throw by IOException in loadSplash method : ", e);
        }
    }

    private void fadeOutFinished(){
        try {
            AnchorPane parentContent = FXMLLoader.load(getClass().getResource(("/views/LogInPage.fxml")));
            anchorPane.getChildren().setAll(parentContent);

        } catch (IOException ex) {
            logger.error("Throw by IOException in fadeOutFinished method: ", ex);
        }
    }

    @FXML
    void onClickedSignInButton(ActionEvent event) throws IOException {
        init();

        //for(Player player: playerService.findAllPlayer()){
        //if(userNameField.getText().equals(player.getUserName()) && passwordField.getText().equals(player.getPassword())){
        changeToLoggedIn(event);
        // }
        //}

    }

    @FXML
    void onClickedSignUpButton(ActionEvent event) throws IOException {

        changeToSignUp(event);
        SignUpController.init();
    }

    @FXML
    void onClickedQuitButton(ActionEvent event){

        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();

    }
}
