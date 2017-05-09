package application.controller.logincontrollers;

import application.Game;
import application.ServiceLocator;
import application.database.PlayerService;
import application.model.player.Player;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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

public class SignInController extends Controller implements Initializable {

    private static PlayerService playerService;

    Logger logger = LoggerFactory.getLogger(SignInController.class);

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


    private static Player signedInPlayer;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        playerService = ServiceLocator.getService(PlayerService.class);

        if (!Game.isSplashLoaded) {
            loadSplashScreen(anchorPane);//1,43 0,98 26,98 2,78

        }
    }


    @FXML
    void onClickedSignInButton(ActionEvent event) throws IOException {

        for (Player player : playerService.findAllPlayer()) {
            if (userNameField.getText().equals(player.getUserName()) && passwordField.getText().equals(player.getPassword())) {
                signedInPlayer = player;
                changeToScreen("/views/loginpages/LoggedInPage.fxml", event);
            }
        }

    }

    @FXML
    void onClickedSignUpButton(ActionEvent event) {
        try {
            changeToScreen("/views/loginpages/SignUpPage.fxml", event);
        } catch (IOException ex) {
            logger.error("Exception on sign up button :", ex);
        }
    }

    @FXML
    void onClickedQuitButton(ActionEvent event) {

        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();

    }

    public static Player getSignedInPlayer() {
        return signedInPlayer;
    }
}
