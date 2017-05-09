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
import java.util.*;

public class GamePageOneController extends GamePageController implements Initializable {

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
    private Line redLine;

    @FXML
    private Line blueLine;

    @FXML
    private Label questionLabel;

    @FXML
    private Label redLabel;

    @FXML
    private Label blueLabel;

    @FXML
    private Label timeLabel;

    @FXML
    void onClickedRedLine(MouseEvent event) throws IOException {



            if (!redLabel.getText().equals(questionLabel.getText())) {
                checkLastAnswer++;
                redLine.setVisible(false);
                redLabel.setVisible(false);
            } else
                gameOver(anchorPane);

            if (checkLastAnswer == 1) {
                changeToNextGamePage(anchorPane, "/views/gamepages/GamePageTwo.fxml");

            }

    }

    @FXML
    void onClickedBlueLine(MouseEvent event) throws IOException {


            if (!blueLabel.getText().equals(questionLabel.getText())) {
                checkLastAnswer++;
                blueLine.setVisible(false);
                blueLabel.setVisible(false);
            } else
                gameOver(anchorPane);

            if (checkLastAnswer == 1) {

                changeToNextGamePage(anchorPane, "/views/gamepages/GamePageTwo.fxml");

            }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        questionService = ServiceLocator.getService(QuestionService.class);

        randomNumberForQuestion = randomNumbers((questionService.findAllQuestion().size()), 6, true);

        labels = new ArrayList<>();
        answers = new ArrayList<>();
        labels.add(blueLabel);
        labels.add(redLabel);

        List<Integer> randomNumbers = randomNumbers(labels.size(), 2, false);

        question = questionService.findById(randomNumberForQuestion.get(0));

        answers.add(question.getCorrectAnswer());
        answers.add(question.getInCorrectAnswer1());

        questionLabel.setText(question.getQuestion());
        blueLabel.setText(answers.get(randomNumbers.get(0)));
        redLabel.setText(answers.get(randomNumbers.get(1)));

        countDown(anchorPane, timeLabel);

    }


}
