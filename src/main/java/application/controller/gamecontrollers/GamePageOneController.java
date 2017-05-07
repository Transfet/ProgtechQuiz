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
import java.util.*;

public class GamePageOneController extends GamePageController implements Initializable {

    private boolean isClickedOnBlueLine = false;
    private boolean isClickedOnRedLine = false;
    private int checkLastAnswer = 0;

    private Logger logger = LoggerFactory.getLogger(GamePageOneController.class);

    @FXML
    private ImageView bombImage;

    private QuestionService questionService;
    private Question firstQuestion;

    private List<Label> labels;

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
    void onClickedRedLine(MouseEvent event) throws IOException {

        isClickedOnRedLine = true;

        if (!redLabel.getText().equals(questionLabel.getText())) {
            checkLastAnswer++;
            redLine.setStroke(Color.BLACK);
        } else
            gameOver(anchorPane);

        if (checkLastAnswer == 1) {
            changeToNextGamePage(anchorPane, "/views/gamepages/GamePageTwo.fxml");
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


        if (checkLastAnswer == 1) {

            changeToNextGamePage(anchorPane, "/views/gamepages/GamePageTwo.fxml");

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
            blueLine.setStroke(Color.BLUE);
        }

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
            redLine.setStroke(Color.RED);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        questionService = ServiceLocator.getService(QuestionService.class);
        labels = new ArrayList<Label>();
        labels.add(blueLabel);
        labels.add(redLabel);

        //  ArrayList<Question> questions = randomQuestions(questionService,2);

        List<Integer> randomNumbersForQuestion = randomNumbers((questionService.findAllQuestion().size()), 2, true);
        List<Integer> randomNumbers = randomNumbers(labels.size(), 2, false);

        ArrayList<Question> questions = new ArrayList<>();

        questions.add(questionService.findById(randomNumbersForQuestion.get(0)));
        questions.add(questionService.findById(randomNumbersForQuestion.get(1)));

        logger.info(questions.get(0).toString());
        logger.info(questions.get(1).toString());

        Question question1 = questions.get(0);

        questionLabel.setText(question1.getQuestion());
        blueLabel.setText(questions.get(randomNumbers.get(0)).getAnswer());
        redLabel.setText(questions.get(randomNumbers.get(1)).getAnswer());

    }


}
