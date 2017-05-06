package application.controller.logincontrollers;

import application.Game;
import application.ServiceLocator;
import application.database.PlayerService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignInController implements Initializable {

    private static PlayerService playerService;

    Logger logger = LoggerFactory.getLogger(SignInController.class);

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private JFXButton TestDB;

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
    void onClickedTestDB(ActionEvent event)throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("/views/TestQuestionDB.fxml"));
        Scene scene = new Scene(root);

        Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        appStage.setScene(scene);

        appStage.show();


    }

    private void changeToSignUp(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/views/loginpages/SignUpPage.fxml"));
        Scene scene = new Scene(root);

        Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        appStage.setScene(scene);

        appStage.show();

    }

    private void changeToLoggedIn(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/views/loginpages/LoggedInPage.fxml"));
        Scene scene = new Scene(root);

        Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        appStage.setScene(scene);

        appStage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        playerService = ServiceLocator.getService(PlayerService.class);

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
            AnchorPane parentContent = FXMLLoader.load(getClass().getResource(("/views/loginpages/SignInPage.fxml")));
            anchorPane.getChildren().setAll(parentContent);

        } catch (IOException ex) {
            logger.error("Throw by IOException in fadeOutFinished method: ", ex);
        }
    }

    @FXML
    void onClickedSignInButton(ActionEvent event) throws IOException {

        //for(Player player: playerService.findAllPlayer()){
        //if(userNameField.getText().equals(player.getUserName()) && passwordField.getText().equals(player.getPassword())){
        changeToLoggedIn(event);
        // }
        //}

    }

    @FXML
    void onClickedSignUpButton(ActionEvent event) throws IOException {

        changeToSignUp(event);
    }

    @FXML
    void onClickedQuitButton(ActionEvent event){

        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();

    }

    @FXML
    void mouseNotOverSignInButton(MouseEvent event){

        signInButton.setStyle("-fx-background-color: #007bff");


    }

    @FXML
    void mouseOverSignInButton(MouseEvent event){

        //signInButton.setStyle("-fx-background-color: rgba(164,174,126,0.87)");
        signInButton.setStyle("-fx-background-color: dimgrey");

    }

    @FXML
    void mouseNotOverSignUpButton(MouseEvent event){
        signUpButton.setStyle("-fx-background-color: #007bff");
    }

    @FXML
    void mouseOverSignUpButton(MouseEvent event){
        signUpButton.setStyle("-fx-background-color: dimgrey");
    }

    @FXML
    void mouseOverQuitButton(MouseEvent event){
        quitButton.setStyle("-fx-background-color: dimgrey");
    }

    @FXML
    void mouseNotOverQuitButton(MouseEvent event){
        quitButton.setStyle("-fx-background-color: #007bff");
    }
}
