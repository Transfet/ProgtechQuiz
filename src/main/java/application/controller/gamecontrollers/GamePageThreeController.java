package application.controller.gamecontrollers;

/**
 * Created by Transfet on 2017. 05. 06..
 */


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

public class GamePageThreeController extends GamePageController implements Initializable {


    private int checkLastAnswer = 0;

    private Logger logger = LoggerFactory.getLogger(GamePageOneController.class);

    @FXML
    private ImageView bombImage;

    private QuestionService questionService;
    private Question question;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label timeLabel;

    @FXML
    private Line orangeLine;

    @FXML
    private Line greenLine;

    @FXML
    private Line purpleLine;

    @FXML
    private Line redLine;

    @FXML
    private Label questionLabel;

    @FXML
    private Label redLabel;

    @FXML
    private Label purpleLabel;

    @FXML
    private Label greenLabel;

    @FXML
    private Label orangeLabel;


    @FXML
    void onClickedGreenLine(MouseEvent event) throws IOException {


        if (onClickLine(anchorPane, event, greenLabel, questionLabel, greenLine))
            checkLastAnswer++;

        if (checkLastAnswer == 3) {
            changeToNextGamePage(anchorPane, "/views/gamepages/GamePageFour.fxml");
        }
    }

    @FXML
    void onClickedPurpleLine(MouseEvent event) throws IOException {


        if (onClickLine(anchorPane, event, purpleLabel, questionLabel, purpleLine))
            checkLastAnswer++;

        if (checkLastAnswer == 3) {

            changeToNextGamePage(anchorPane, "/views/gamepages/GamePageFour.fxml");

        }

    }

    @FXML
    void onClickedOrangeLine(MouseEvent event) throws IOException {


        if (onClickLine(anchorPane, event, orangeLabel, questionLabel, orangeLine))
            checkLastAnswer++;

        if (checkLastAnswer == 3) {
            changeToNextGamePage(anchorPane, "/views/gamepages/GamePageFour.fxml");
        }
    }


    @FXML
    void onClickedRedLine(MouseEvent event) throws IOException {


        if (onClickLine(anchorPane, event, redLabel, questionLabel, redLine))
            checkLastAnswer++;

        if (checkLastAnswer == 3) {
            changeToNextGamePage(anchorPane, "/views/gamepages/GamePageFour.fxml");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        questionService = ServiceLocator.getService(QuestionService.class);

        ArrayList<Label> labels = new ArrayList<>();
        ArrayList<String> answers = new ArrayList<>();

        labels.add(purpleLabel);
        labels.add(greenLabel);
        labels.add(orangeLabel);
        labels.add(redLabel);


        List<Integer> randomNumbers = randomNumbers(labels.size(), labels.size(), false);
        List<Question> questions = questionService.findAllQuestion();


        question = questionService.findById(randomNumberForQuestion.get(2));

        logger.info(Integer.toString(labels.size()));
        logger.info(Integer.toString(questions.size()));
        logger.info(Integer.toString(randomNumberForQuestion.get(2)));

        for (Integer i : randomNumberForQuestion) {
            logger.info(Integer.toString(i));
        }

        answers.add(question.getCorrectAnswer());
        answers.add(question.getInCorrectAnswer1());
        answers.add(question.getInCorrectAnswer3());
        answers.add(question.getInCorrectAnswer4());

        for (String s : answers) {
            logger.info("asnw:" + s);
        }
        questionLabel.setText(question.getQuestion());

        questionLabel.setText(question.getQuestion());
        purpleLabel.setText(answers.get(randomNumbers.get(0)));
        greenLabel.setText(answers.get(randomNumbers.get(1)));
        orangeLabel.setText(answers.get(randomNumbers.get(2)));
        redLabel.setText(answers.get(randomNumbers.get(3)));

        countDown(anchorPane, timeLabel);
    }

}
