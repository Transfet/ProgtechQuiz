package hu.transfet.unideb.application.controller.logincontrollers;

import hu.transfet.unideb.application.Game;
import hu.transfet.unideb.application.ServiceLocator;
import hu.transfet.unideb.application.controller.Controller;
import hu.transfet.unideb.application.service.PlayerServiceImpl;
import hu.transfet.unideb.application.model.player.Player;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignInController extends Controller implements Initializable {

    private static PlayerServiceImpl playerService;

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

        playerService = ServiceLocator.getService(PlayerServiceImpl.class);

        if (!Game.isSplashLoaded) {

            loadSplashScreen(anchorPane);

        }
    }


    @FXML
    void onClickedSignInButton(ActionEvent event) throws IOException {

        for (Player player : playerService.findAllPlayer()) {
            if (userNameField.getText().equals(player.getUserName()) && passwordField.getText().equals(player.getPassword())) {
                signedInPlayer = player;
                changeToScreen("LoggedInPage.fxml", event);
            }
        }

    }

    @FXML
    void onClickedSignUpButton(ActionEvent event) {

            changeToScreen("SignUpPage.fxml", event);
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
