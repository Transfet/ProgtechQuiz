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

public class GamePageFourController extends GamePageController implements Initializable {


    private int checkLastAnswer = 0;

    private Logger logger = LoggerFactory.getLogger(GamePageOneController.class);

    @FXML
    private ImageView bombImage;

    private QuestionService questionService;
    private Question question;

    private List<Question> questions;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Line orangeLine;

    @FXML
    private Line greenLine;

    @FXML
    private Line purpleLine;

    @FXML
    private Line redLine;

    @FXML
    private Line skyBlueLine;

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
    private Label skyBlueLabel;

    @FXML
    private Label timeLabel;

    @FXML
    void onClickedSkyBlueLine(MouseEvent event) throws IOException {


        if (onClickLine(anchorPane, event, skyBlueLabel, questionLabel, skyBlueLine))
            checkLastAnswer++;
        if (checkLastAnswer == 4) {
            changeToNextGamePage(anchorPane, "/views/gamepages/GamePageFive.fxml");
        }
    }

    @FXML
    void onClickedGreenLine(MouseEvent event) throws IOException {


        if (onClickLine(anchorPane, event, greenLabel, questionLabel, greenLine))
            checkLastAnswer++;

        if (checkLastAnswer == 4) {
            changeToNextGamePage(anchorPane, "/views/gamepages/GamePageFive.fxml");
        }
    }

    @FXML
    void onClickedPurpleLine(MouseEvent event) throws IOException {


        if (onClickLine(anchorPane, event, purpleLabel, questionLabel, purpleLine))
            checkLastAnswer++;

        if (checkLastAnswer == 4) {

            changeToNextGamePage(anchorPane, "/views/gamepages/GamePageFive.fxml");

        }

    }

    @FXML
    void onClickedOrangeLine(MouseEvent event) throws IOException {


        if (onClickLine(anchorPane, event, orangeLabel, questionLabel, orangeLine))
            checkLastAnswer++;

        if (checkLastAnswer == 4) {
            changeToNextGamePage(anchorPane, "/views/gamepages/GamePageFive.fxml");
        }
    }


    @FXML
    void onClickedRedLine(MouseEvent event) throws IOException {


        if (onClickLine(anchorPane, event, redLabel, questionLabel, redLine))
            checkLastAnswer++;

        if (checkLastAnswer == 4) {
            changeToNextGamePage(anchorPane, "/views/gamepages/GamePageFive.fxml");
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        questionService = ServiceLocator.getService(QuestionService.class);

        ArrayList<String> answers = new ArrayList<>();

        ArrayList<Label> labels = new ArrayList<>();

        labels.add(purpleLabel);
        labels.add(greenLabel);
        labels.add(orangeLabel);
        labels.add(redLabel);
        labels.add(skyBlueLabel);

        List<Integer> randomNumbers = randomNumbers(labels.size(), labels.size(), false);
        List<Question> questions = questionService.findAllQuestion();

        logger.info(Integer.toString(labels.size()));
        logger.info(Integer.toString(questions.size()));
        logger.info(Integer.toString(randomNumberForQuestion.get(3)));

        for (Integer i : randomNumberForQuestion) {
            logger.info(Integer.toString(i));
        }


        question = questionService.findById(randomNumberForQuestion.get(3));

        answers.add(question.getCorrectAnswer());
        answers.add(question.getInCorrectAnswer1());
        answers.add(question.getInCorrectAnswer3());
        answers.add(question.getInCorrectAnswer4());
        answers.add(question.getInCorrectAnswer5());

        for (String s : answers) {
            logger.info("asnw:" + s);
        }

        questionLabel.setText(question.getQuestion());
        purpleLabel.setText(answers.get(randomNumbers.get(0)));
        greenLabel.setText(answers.get(randomNumbers.get(1)));
        orangeLabel.setText(answers.get(randomNumbers.get(2)));
        redLabel.setText(answers.get(randomNumbers.get(3)));
        skyBlueLabel.setText(answers.get(randomNumbers.get(4)));

        countDown(anchorPane, timeLabel);

    }

}
