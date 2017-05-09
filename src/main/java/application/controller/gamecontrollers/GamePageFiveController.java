package application.controller.gamecontrollers;

/**
 * Created by Transfet on 2017. 05. 06..
 */


import application.Game;
import application.ServiceLocator;
import application.database.QuestionService;
import application.model.questions.Question;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GamePageFiveController extends GamePageController implements Initializable {

    private boolean isClickedOnGreenLine = false;
    private boolean isClickedOnRedLine = false;
    private boolean isClickedOnOrangeLine = false;
    private boolean isClickedPurpleLine = false;
    private boolean isClickedSkyBlueLine = false;
    private boolean isClickedPinkLine = false;

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
    private Line pinkLine;

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
    private Label pinkLabel;

    @FXML
    private Label timeLabel;

    @FXML
    void onClickedSkyBlueLine(MouseEvent event) throws IOException {

        isClickedSkyBlueLine = true;

        if (!skyBlueLabel.getText().equals(questionLabel.getText())) {
            checkLastAnswer++;
            skyBlueLine.setStroke(Color.BLACK);
        } else
            gameOver(anchorPane);

        if (checkLastAnswer == 5) {
            changeToNextGamePage(anchorPane, "/views/gamepages/GamePageSix.fxml");
        }
    }

    @FXML
    void onClickedPinkLine(MouseEvent event) throws IOException {

        isClickedPinkLine = true;

        if (!pinkLabel.getText().equals(questionLabel.getText())) {
            checkLastAnswer++;
            pinkLine.setStroke(Color.BLACK);
        } else
            gameOver(anchorPane);

        if (checkLastAnswer == 5) {
            changeToNextGamePage(anchorPane, "/views/gamepages/GamePageSix.fxml");
        }
    }

    @FXML
    void onClickedGreenLine(MouseEvent event) throws IOException {

        isClickedOnGreenLine = true;

        if (!greenLabel.getText().equals(questionLabel.getText())) {
            checkLastAnswer++;
            greenLine.setStroke(Color.BLACK);
        } else
            gameOver(anchorPane);

        if (checkLastAnswer == 5) {
            changeToNextGamePage(anchorPane, "/views/gamepages/GamePageSix.fxml");
        }
    }

    @FXML
    void onClickedPurpleLine(MouseEvent event) throws IOException {
        isClickedPurpleLine = true;

        if (!purpleLabel.getText().equals(questionLabel.getText())) {
            checkLastAnswer++;
            purpleLine.setStroke(Color.BLACK);
        } else
            gameOver(anchorPane);

        if (checkLastAnswer == 5) {

            changeToNextGamePage(anchorPane, "/views/gamepages/GamePageSix.fxml");

        }

    }

    @FXML
    void onClickedOrangeLine(MouseEvent event) throws IOException {

        isClickedOnOrangeLine = true;

        if (!orangeLabel.getText().equals(questionLabel.getText())) {
            checkLastAnswer++;
            orangeLine.setStroke(Color.BLACK);
        } else
            gameOver(anchorPane);

        if (checkLastAnswer == 5) {
            changeToNextGamePage(anchorPane, "/views/gamepages/GamePageSix.fxml");
        }
    }


    @FXML
    void onClickedRedLine(MouseEvent event) throws IOException {

        isClickedOnRedLine = true;

        if (!redLabel.getText().equals(questionLabel.getText())) {
            checkLastAnswer++;
            redLine.setStroke(Color.BLACK);
        } else
            gameOver(anchorPane);

        if (checkLastAnswer == 5) {
            changeToNextGamePage(anchorPane, "/views/gamepages/GamePageSix.fxml");
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        questionService = ServiceLocator.getService(QuestionService.class);

        ArrayList<String>answers = new ArrayList<>();
        ArrayList<Label> labels = new ArrayList<Label>();
        labels.add(purpleLabel);
        labels.add(greenLabel);
        labels.add(orangeLabel);
        labels.add(redLabel);
        labels.add(skyBlueLabel);
        labels.add(pinkLabel);


        List<Integer> randomNumbers = randomNumbers(labels.size(), labels.size(), false);
        List<Question> questions = questionService.findAllQuestion();

        question = questionService.findById(randomNumberForQuestion.get(4));

        logger.info(Integer.toString(labels.size()));
        logger.info(Integer.toString(questions.size()));
        logger.info(Integer.toString(randomNumberForQuestion.get(4)));

        for(Integer i: randomNumberForQuestion){
            logger.info(Integer.toString(i));
        }

        answers.add(question.getCorrectAnswer());
        answers.add(question.getInCorrectAnswer1());
        answers.add(question.getInCorrectAnswer3());
        answers.add(question.getInCorrectAnswer4());
        answers.add(question.getInCorrectAnswer5());
        answers.add(question.getInCorrectAnswer6());

        for(String s: answers){
            logger.info("asnw:" + s);
        }

        questionLabel.setText(question.getQuestion());
        purpleLabel.setText(answers.get(randomNumbers.get(0)));
        greenLabel.setText(answers.get(randomNumbers.get(1)));
        orangeLabel.setText(answers.get(randomNumbers.get(2)));
        redLabel.setText(answers.get(randomNumbers.get(3)));
        skyBlueLabel.setText(answers.get(randomNumbers.get(4)));
        pinkLabel.setText(answers.get(randomNumbers.get(5)));

        countDown(anchorPane,timeLabel);
    }

}
