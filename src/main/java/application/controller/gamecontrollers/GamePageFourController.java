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
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GamePageFourController extends GamePageController implements Initializable {

    private boolean isClickedOnGreenLine = false;
    private boolean isClickedOnRedLine = false;
    private boolean isClickedOnOrangeLine = false;
    private boolean isClickedPurpleLine = false;
    private boolean isClickedSkyBlueLine = false;

    private int checkLastAnswer = 0;

    private Logger logger = LoggerFactory.getLogger(GamePageOneController.class);

    @FXML
    private ImageView bombImage;

    private QuestionService questionService;
    private Question firstQuestion;

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

        isClickedSkyBlueLine = true;

        if (!skyBlueLabel.getText().equals(questionLabel.getText())) {
            checkLastAnswer++;
            skyBlueLine.setStroke(Color.BLACK);
        } else
            gameOver(anchorPane);

        if (checkLastAnswer == 4) {
            changeToNextGamePage(anchorPane, "/views/gamepages/GamePageFive.fxml");
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

        if (checkLastAnswer == 4) {
            changeToNextGamePage(anchorPane, "/views/gamepages/GamePageFive.fxml");
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

        if (checkLastAnswer == 4) {

            changeToNextGamePage(anchorPane, "/views/gamepages/GamePageFive.fxml");

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

        if (checkLastAnswer == 4) {
            changeToNextGamePage(anchorPane, "/views/gamepages/GamePageFive.fxml");
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

        if (checkLastAnswer == 4) {
            changeToNextGamePage(anchorPane, "/views/gamepages/GamePageFive.fxml");
        }
    }

    @FXML
    void cursorOverSkyBlueLine(MouseEvent event) {

        if (!isClickedSkyBlueLine) {
            skyBlueLine.setStroke(Color.GRAY);
        }

    }

    @FXML
    void cursorNotOverSkyBlueLine(MouseEvent event) {

        if (!isClickedSkyBlueLine) {
            skyBlueLine.setStroke(Color.valueOf("#00f9ff"));
        }

    }


    @FXML
    void cursorOverOrangeLine(MouseEvent event) {

        if (!isClickedOnOrangeLine) {
            orangeLine.setStroke(Color.GRAY);
        }

    }

    @FXML
    void cursorNotOverOrangeLine(MouseEvent event) {

        if (!isClickedOnOrangeLine) {
            orangeLine.setStroke(Color.valueOf("#ffbf00"));
        }

    }

    @FXML
    void cursorOverPurpleLine(MouseEvent event) {

        if (!isClickedPurpleLine) {
            purpleLine.setStroke(Color.GRAY);
        }

    }

    @FXML
    void cursorNotOverPurpleLine(MouseEvent event) {

        if (!isClickedPurpleLine) {
            purpleLine.setStroke(Color.valueOf("#7900ff"));
        }

    }

    @FXML
    void cursorOverGreenLine(MouseEvent event) {
        if (!isClickedOnGreenLine) {
            greenLine.setStroke(Color.GRAY);
        }
    }

    @FXML
    void cursorNotOverGreenLine(MouseEvent event) {
        if (!isClickedOnGreenLine)
            greenLine.setStroke(Color.valueOf("#11c678"));
    }

    @FXML
    void cursorOverRedLine(MouseEvent event) {

        if (!isClickedOnRedLine) {
            redLine.setStroke(Color.GRAY);
        }
    }

    @FXML
    void cursorNotOverRedLine(MouseEvent event) {
        if (!isClickedOnRedLine)
            redLine.setStroke(Color.valueOf("#ff0000"));
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        questionService = ServiceLocator.getService(QuestionService.class);

        ArrayList<Label> labels = new ArrayList<Label>();
        labels.add(purpleLabel);
        labels.add(greenLabel);
        labels.add(orangeLabel);
        labels.add(redLabel);
        labels.add(skyBlueLabel);


        List<Integer> randomNumbersForQuestion = randomNumbers((questionService.findAllQuestion().size()), labels.size(), true);
        List<Integer> randomNumbers = randomNumbers(labels.size(), labels.size(), false);

        ArrayList<Question> questions = new ArrayList<>();

        questions.add(questionService.findById(randomNumbersForQuestion.get(0)));
        questions.add(questionService.findById(randomNumbersForQuestion.get(1)));
        questions.add(questionService.findById(randomNumbersForQuestion.get(2)));
        questions.add(questionService.findById(randomNumbersForQuestion.get(3)));
        questions.add(questionService.findById(randomNumbersForQuestion.get(4)));

        logger.info(questions.get(0).toString());
        logger.info(questions.get(1).toString());

        Question question1 = questions.get(0);

        questionLabel.setText(question1.getQuestion());
        purpleLabel.setText(questions.get(randomNumbers.get(0)).getAnswer());
        greenLabel.setText(questions.get(randomNumbers.get(1)).getAnswer());
        orangeLabel.setText(questions.get(randomNumbers.get(2)).getAnswer());
        redLabel.setText(questions.get(randomNumbers.get(3)).getAnswer());
        skyBlueLabel.setText(questions.get(randomNumbers.get(4)).getAnswer());

        countDown(anchorPane,timeLabel);

    }

}
