package application.controller.logincontrollers;

/**
 * Created by Transfet on 2017. 05. 05..
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.model.player.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class LoggedInController extends Controller implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button quitButton;

    @FXML
    private Button startButton;

    @FXML
    private Label statusLabel;

    private static Player signedInPlayer;


    @FXML
    void onClickedStartButton(ActionEvent event) throws IOException {

        changeToScreen("/views/gamepages/GamePageOne.fxml", event);

    }

    @FXML
    void onClickedQuitButton(ActionEvent event) {

        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        signedInPlayer = SignInController.getSignedInPlayer();

        System.out.println(signedInPlayer);


    }

}
