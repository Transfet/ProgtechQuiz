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

public class GamePageTwoController extends GamePageController implements Initializable {

    private boolean isClickedOnGreenLine = false;
    private boolean isClickedOnBlueLine = false;
    private boolean isClickedOnSkyBlueLine = false;
    private int checkLastAnswer = 0;

    private Logger logger = LoggerFactory.getLogger(GamePageOneController.class);

    @FXML
    private ImageView bombImage;

    private QuestionService questionService;
    private Question firstQuestion;

    private List<Label> labels;

    private List<Question> questions;

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

        isClickedOnGreenLine = true;

        if (!greenLabel.getText().equals(questionLabel.getText())) {
            checkLastAnswer++;
            greenLine.setStroke(Color.BLACK);
        } else
            gameOver(anchorPane);

        if (checkLastAnswer == 2) {
            changeToNextGamePage(anchorPane, "/views/gamepages/GamePageThree.fxml");
        }
    }

    @FXML
    void onClickedBlueLine(MouseEvent event) throws IOException {
        isClickedOnBlueLine = true;

        if (!blueLabel.getText().equals(questionLabel.getText())) {
            checkLastAnswer++;
            blueLine.setStroke(Color.BLACK);
        } else
            gameOver(anchorPane);

        if (checkLastAnswer == 2) {

            changeToNextGamePage(anchorPane, "/views/gamepages/GamePageThree.fxml");

        }

    }

    @FXML
    void onClickedSkyBlueLine(MouseEvent event) throws IOException {

        isClickedOnSkyBlueLine = true;

        if (!skyBlueLabel.getText().equals(questionLabel.getText())) {
            checkLastAnswer++;
            skyBlueLine.setStroke(Color.BLACK);
        } else
            gameOver(anchorPane);

        if (checkLastAnswer == 2) {
            changeToNextGamePage(anchorPane, "/views/gamepages/GamePageThree.fxml");
        }
    }


    @FXML
    void cursorOverSkyBlueLine(MouseEvent event) {

        if (!isClickedOnSkyBlueLine) {
            skyBlueLine.setStroke(Color.GRAY);
        }

    }

    @FXML
    void cursorNotOverSkyBlueLine(MouseEvent event) {

        if (!isClickedOnSkyBlueLine) {
            skyBlueLine.setStroke(Color.valueOf("#00ebff"));
        }

    }

    @FXML
    void cursorOverBlueLine(MouseEvent event) {

        if (!isClickedOnBlueLine) {
            blueLine.setStroke(Color.GRAY);
        }

    }

    @FXML
    void cursorNotOverBlueLine(MouseEvent event) {

        if (!isClickedOnBlueLine) {
            blueLine.setStroke(Color.valueOf("#005eff"));
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
            greenLine.setStroke(Color.valueOf("#3fff00"));
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        questionService = ServiceLocator.getService(QuestionService.class);

        labels = new ArrayList<Label>();
        labels.add(blueLabel);
        labels.add(greenLabel);
        labels.add(skyBlueLabel);

        List<Integer> randomNumbersForQuestion = randomNumbers((questionService.findAllQuestion().size()), labels.size(), true);
        List<Integer> randomNumbers = randomNumbers(labels.size(), labels.size(), false);

        ArrayList<Question> questions = new ArrayList<>();

        questions.add(questionService.findById(randomNumbersForQuestion.get(0)));
        questions.add(questionService.findById(randomNumbersForQuestion.get(1)));
        questions.add(questionService.findById(randomNumbersForQuestion.get(2)));

        Question question1 = questions.get(0);

        questionLabel.setText(question1.getQuestion());
        blueLabel.setText(questions.get(randomNumbers.get(0)).getAnswer());
        greenLabel.setText(questions.get(randomNumbers.get(1)).getAnswer());
        skyBlueLabel.setText(questions.get(randomNumbers.get(2)).getAnswer());

        countDown(anchorPane,timeLabel);

    }

}
