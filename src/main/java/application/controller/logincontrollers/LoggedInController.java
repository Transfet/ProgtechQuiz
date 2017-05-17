package application.controller.logincontrollers;

/**
 * Created by Transfet on 2017. 05. 05..
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.ServiceLocator;
import application.database.QuestionService;
import application.model.player.Player;
import application.model.questions.Question;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
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
    void onClickedStartButton(ActionEvent event) throws IOException {

        changeToScreen("/views/gamepages/GamePageOne.fxml", event);

    }

    @FXML
    void onClickedSignOutButton(ActionEvent event) throws IOException {

        signedInPlayer = null;
        changeToScreen("/views/loginpages/SignInPage.fxml", event);

    }

    @FXML
    void onClickedQuitButton(ActionEvent event) {

        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();

    }

    @FXML
    void onClickedTableButton(ActionEvent event) throws IOException {
        fromLoggedIn = true;
        changeToScreen("/views/Result.fxml", event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        QuestionService questionService = ServiceLocator.getService(QuestionService.class);

        questionService.addQuestion(new Question("111", "111", "222", "333", "444", "555", "666", "777"));
        questionService.addQuestion(new Question("222", "222", "111", "333", "444", "555", "666", "777"));
        questionService.addQuestion(new Question("333", "333", "222", "111", "444", "555", "666", "777"));
        questionService.addQuestion(new Question("444", "444", "222", "333", "111", "555", "666", "777"));
        questionService.addQuestion(new Question("555", "555", "222", "333", "444", "111", "666", "777"));
        questionService.addQuestion(new Question("666", "666", "222", "333", "444", "555", "111", "777"));

        signedInPlayer = SignInController.getSignedInPlayer();
        logger.info("Signed as: " + signedInPlayer.toString());


        signedInLabel.setText("Welcome: " + signedInPlayer.getUserName());
    }

}
