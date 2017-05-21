package hu.transfet.unideb.application.controller.logincontrollers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import hu.transfet.unideb.application.ServiceLocator;
import hu.transfet.unideb.application.model.answer.Answer;
import hu.transfet.unideb.application.service.QuestionServiceImpl;
import hu.transfet.unideb.application.model.player.Player;
import hu.transfet.unideb.application.model.questions.Question;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoggedInController extends Controller implements Initializable {


    Logger logger = LoggerFactory.getLogger(LoggedInController.class);

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button quitButton;

    @FXML
    private Button startButton;

    @FXML
    private Button tableButton;

    @FXML
    private Label signedInLabel;

    @FXML
    private Button signOutButton;

    private static Player signedInPlayer;

    public static boolean fromLoggedIn = false;


    @FXML
    void onClickedStartButton(ActionEvent event){

        changeToScreen("/views/gamepages/GamePage.fxml", event);

    }

    @FXML
    void onClickedSignOutButton(ActionEvent event){

        signedInPlayer = null;
        changeToScreen("/views/loginpages/SignInPage.fxml", event);

    }

    @FXML
    void onClickedQuitButton(ActionEvent event) {

        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();

    }

    @FXML
    void onClickedTableButton(ActionEvent event){
        fromLoggedIn = true;
        changeToScreen("/views/Result.fxml", event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        signedInPlayer = SignInController.getSignedInPlayer();
        logger.info("Signed as: " + signedInPlayer.toString());

        signedInLabel.setText("Welcome: " + signedInPlayer.getUserName());
    }

}
