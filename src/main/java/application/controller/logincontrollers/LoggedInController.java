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

    @FXML
    void mouseOverSignOutButton(MouseEvent event) {
        signOutButton.setStyle("-fx-background-color: #ECF0F1");
    }

    @FXML
    void mouseNotOverSignOutButton(MouseEvent event) {
        signOutButton.setStyle("-fx-background-color: #E74C3C");
    }

    @FXML
    void mouseOverQuitButton(MouseEvent event) {
        quitButton.setStyle("-fx-background-color: #ECF0F1");
    }

    @FXML
    void mouseNotOverQuitButton(MouseEvent event) {
        quitButton.setStyle("-fx-background-color: #E74C3C");
    }

    @FXML
    void mouseOverStartButton(MouseEvent event) {
        startButton.setStyle("-fx-background-color: #ECF0F1");
    }

    @FXML
    void mouseNotOverStartButton(MouseEvent event) {
        startButton.setStyle("-fx-background-color: #E74C3C");
    }

    @FXML
    void mouseOverTableButton(MouseEvent event) {
        tableButton.setStyle("-fx-background-color: #ECF0F1");
    }

    @FXML
    void mouseNotOverTableButton(MouseEvent event) {
        tableButton.setStyle("-fx-background-color: #E74C3C");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        QuestionService questionService = ServiceLocator.getService(QuestionService.class);

        questionService.addQuestion(new Question("What are the various access specifiers for Java classes?", "In Java, access specifiers are the keywords used before a class name which defines the access scope. "));
        questionService.addQuestion(new Question("What is data encapsulation and what’s its significance?", "Encapsulation is a concept in Object Oriented Programming for combining properties and methods in a single unit."));
        questionService.addQuestion(new Question("What are Loops in Java?", "Looping is used in programming to execute a statement or a block of statement repeatedly."));
        questionService.addQuestion(new Question("What is an infinite Loop?", "An infinite loop runs without any condition and runs infinitely. An infinite loop can be broken by defining any breaking logic in the body of the statement blocks."));
        questionService.addQuestion(new Question("What is Final Keyword in Java?", "a constant is declared using the keyword Final. Value can be assigned only once and after assignment, value of a constant can’t be changed."));
        questionService.addQuestion(new Question("When the constructor of a class is invoked?", "every time an object is created with new keyword."));
        questionService.addQuestion(new Question("Why Runnable Interface is used in Java?", "Runnable interface is used in java for implementing multi threaded applications."));


        signedInPlayer = SignInController.getSignedInPlayer();

        signedInLabel.setText("Welcome: " + signedInPlayer.getUserName());
    }

}
