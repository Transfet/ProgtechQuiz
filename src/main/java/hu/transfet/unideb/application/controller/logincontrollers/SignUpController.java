package hu.transfet.unideb.application.controller.logincontrollers;

import hu.transfet.unideb.application.ServiceLocator;
import hu.transfet.unideb.application.controller.Controller;
import hu.transfet.unideb.application.service.*;
import hu.transfet.unideb.application.model.player.Player;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController extends Controller implements Initializable {


    private PlayerServiceImpl playerService;

    private Logger logger = LoggerFactory.getLogger(SignUpController.class);

    @FXML
    private JFXTextField userNameField;

    @FXML
    private JFXPasswordField passwordField;

    @FXML
    private JFXTextField lastNameField;

    @FXML
    private JFXTextField firstNameField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        playerService = ServiceLocator.getService(PlayerServiceImpl.class);

    }

    @FXML
    void onClickedSignUpButton(ActionEvent event)throws IOException {

        addPlayer();
        clearFields();
        changeToScreen("SignInPage.fxml",event);
    }

    @FXML
    void onClickedBackButton(ActionEvent event) {
            changeToScreen("SignInPage.fxml", event);
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

        Player player = new Player();
        player.setUserName(username);
        player.setFirstName(firstName);
        player.setLastName(lastName);
        player.setPassword(password);

        try {
            playerService.addPlayer(player);
        } catch (DataAccessException Dae) {
            logger.error("Added player was not successfully: ", Dae);

        }

        logger.debug("Added new player to DB: " + player.toString());

    }


}
