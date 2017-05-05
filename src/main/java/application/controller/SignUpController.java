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
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class SignUpController {


    private static PlayerService playerService;

    private Logger logger = LoggerFactory.getLogger(SignUpController.class);


    public static void init() {
        playerService = ServiceLocator.getService(PlayerService.class);
    }


    private void changeToLogIn(ActionEvent event) throws IOException {

        Stage prevStage = (Stage) signUpButton.getScene().getWindow();

        Stage stage = new Stage();
        stage.setTitle("Logged In");
        Pane myPane;

        myPane = FXMLLoader.load(getClass().getResource("/views/LogInPage.fxml"));
        Scene scene = new Scene(myPane);

        stage.setScene(scene);

        prevStage.close();

        stage.show();

    }

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

    @FXML
    void onClickedSignUpButton(ActionEvent event) {

        Player player = new Player();
        //player.setPoints(Double.parseDouble(p));
        player.setFirstName(firstNameField.getText());
        player.setLastName(lastNameField.getText());
        player.setUserName(userNameField.getText());
        player.setPassword(passwordField.getText());

        playerService.addPlayer(player);

        userNameField.clear();
        firstNameField.clear();
        lastNameField.clear();
        passwordField.clear();
        //point.clear();

        logger.info("-----------------------------");
        logger.info("Added a new User to the DB: ");
        logger.info(player.toString());
        logger.info("--");

    }

    @FXML
    void onClickedBackButton(ActionEvent event) throws IOException {
        changeToLogIn(event);

    }

}
