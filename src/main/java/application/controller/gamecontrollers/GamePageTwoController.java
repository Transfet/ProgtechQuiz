package application.controller.gamecontrollers;

import application.ServiceLocator;
import application.database.QuestionService;
import application.model.questions.Question;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GamePageTwoController extends GamePageController implements Initializable {


    private int checkLastAnswer = 0;

    private Logger logger = LoggerFactory.getLogger(GamePageOneController.class);

    @FXML
    private ImageView bombImage;

    private QuestionService questionService;
    private Question question;

    private List<Label> labels;
    private List<String> answers;


    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Line skyBlueLine;

    @FXML
    private Line greenLine;

    @FXML
    private Line blueLine;

    @FXML
    private Label questionLabel;

    @FXML
    private Label skyBlueLabel;

    @FXML
    private Label blueLabel;

    @FXML
    private Label greenLabel;

    @FXML
    private Label timeLabel;

    @FXML
    void onClickedGreenLine(MouseEvent event) throws IOException {

        if (onClickLine(anchorPane, event, greenLabel, questionLabel, greenLine))
            checkLastAnswer++;

        if (checkLastAnswer == 2) {
            changeToNextGamePage(anchorPane, "/views/gamepages/GamePageThree.fxml");
        }

    }

    @FXML
    void onClickedBlueLine(MouseEvent event) throws IOException {


        if (onClickLine(anchorPane, event, blueLabel, questionLabel, blueLine))
            checkLastAnswer++;
        if (checkLastAnswer == 2) {

            changeToNextGamePage(anchorPane, "/views/gamepages/GamePageThree.fxml");

        }

    }

    @FXML
    void onClickedSkyBlueLine(MouseEvent event) throws IOException {


        if (onClickLine(anchorPane, event, skyBlueLabel, questionLabel, skyBlueLine))
            checkLastAnswer++;

        if (checkLastAnswer == 2) {
            changeToNextGamePage(anchorPane, "/views/gamepages/GamePageThree.fxml");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        questionService = ServiceLocator.getService(QuestionService.class);

        answers = new ArrayList<>();
        labels = new ArrayList<>();

        labels.add(blueLabel);
        labels.add(greenLabel);
        labels.add(skyBlueLabel);


        List<Integer> randomNumbers = randomNumbers(labels.size(), labels.size(), false);
        List<Question> questions = questionService.findAllQuestion();

        logger.info(Integer.toString(labels.size()));
        logger.info(Integer.toString(questions.size()));
        logger.info(Integer.toString(randomNumberForQuestion.get(1)));

        for (Integer i : randomNumberForQuestion) {
            logger.info(Integer.toString(i));
        }

        question = questionService.findById(randomNumberForQuestion.get(1));

        answers.add(question.getCorrectAnswer());
        answers.add(question.getInCorrectAnswer1());
        answers.add(question.getInCorrectAnswer3());

        for (String s : answers) {
            logger.info("asnw:" + s);
        }

        questionLabel.setText(question.getQuestion());
        blueLabel.setText(answers.get(randomNumbers.get(0)));
        greenLabel.setText(answers.get(randomNumbers.get(1)));
        skyBlueLabel.setText(answers.get(randomNumbers.get(2)));

        countDown(anchorPane, timeLabel);

    }

}
