package application.controller.logincontrollers;

import application.ServiceLocator;
import application.database.PlayerService;
import application.model.player.Player;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.input.MouseEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController extends Controller implements Initializable {


    private PlayerService playerService;

    private Logger logger = LoggerFactory.getLogger(SignUpController.class);

    @FXML
    private JFXTextField userNameField;

    @FXML
    private JFXButton backButton;

    @FXML
    private JFXButton signUpButton;

    @FXML
    private JFXPasswordField passwordField;

    @FXML
    private JFXTextField lastNameField;

    @FXML
    private JFXTextField firstNameField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        playerService = ServiceLocator.getService(PlayerService.class);

    }

    @FXML
    void onClickedSignUpButton(ActionEvent event)throws IOException {

        addPlayer();
        clearFields();
        changeToScreen("/views/loginpages/SignInPage.fxml",event);
    }

    @FXML
    void onClickedBackButton(ActionEvent event) {
        try {
            changeToScreen("/views/loginpages/SignInPage.fxml", event);
        } catch (IOException ex) {
            logger.error("Error on back button: ", ex);
        }
    }


    private void clearFields() {

        userNameField.clear();
        firstNameField.clear();
        lastNameField.clear();
        passwordField.clear();

    }


    private void addPlayer() {

        String username = userNameField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String password = passwordField.getText();

        Player player = new Player(username,firstName,lastName,password);

        try {
            playerService.addPlayer(player);
        } catch (Exception e) {
            logger.error("Just an Exception: ", e);
        }

        logger.debug("Added new player to DB: " + player.toString());

    }


}
