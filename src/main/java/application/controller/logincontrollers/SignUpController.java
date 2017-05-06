package application.controller.logincontrollers;

import application.ServiceLocator;
import application.database.PlayerService;
import application.model.player.Player;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable{


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

    private void changeToLogIn(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/views/loginpages/SignInPage.fxml"));
        Scene scene = new Scene(root);

        Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        appStage.setScene(scene);

        appStage.show();

    }

    @FXML
    void onClickedSignUpButton(ActionEvent event) {

        Player player = new Player();
        player.setFirstName(firstNameField.getText());
        player.setLastName(lastNameField.getText());
        player.setUserName(userNameField.getText());
        player.setPassword(passwordField.getText());

        playerService.addPlayer(player);

        userNameField.clear();
        firstNameField.clear();
        lastNameField.clear();
        passwordField.clear();

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
