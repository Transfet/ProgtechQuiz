package application.controller.logincontrollers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.ServiceLocator;
import application.database.QuestionService;
import application.model.player.Player;
import application.model.questions.Question;
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

        questionService.addQuestion(new Question("How many pieces are basic Accessibility modifiers?",
                "4",
                "1",
                "2",
                "3",
                "6",
                "5",
                "7"));

        questionService.addQuestion(new Question("Which answer not a Collection class?",
                "The Map",
                "AbstractList",
                "LinkedList",
                "HashSet",
                "AbstractMap",
                "HashMap",
                "LinkedHashMap"));

        questionService.addQuestion(new Question("Which access modifier is one of the basic Accessibility modifiers in Java?",
                "Protected",
                "Static",
                "Abstract",
                "Final",
                "Transient",
                "Native",
                "Volatile"));

        questionService.addQuestion(new Question("Which answer is one of the new features in Java 8?",
                "The javadoc tool supports the new DocTree API",
                "Try-with-resources statement",
                "Multiple exception catching",
                "Generics",
                "Annotation",
                "Autoboxing nad Unboxing",
                "String in switch statement"));

        questionService.addQuestion(new Question("555",
                "555",
                "222",
                "333",
                "444",
                "111",
                "666",
                "777"));

        questionService.addQuestion(new Question("666",
                "666",
                "222",
                "333",
                "444",
                "555",
                "111",
                "777"));


        signedInPlayer = SignInController.getSignedInPlayer();
        logger.info("Signed as: " + signedInPlayer.toString());

        signedInLabel.setText("Welcome: " + signedInPlayer.getUserName());
    }

}
