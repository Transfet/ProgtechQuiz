package hu.transfet.unideb.application.controller.gamecontrollers;

import hu.transfet.unideb.application.ServiceLocator;
import hu.transfet.unideb.application.model.answer.Answer;
import hu.transfet.unideb.application.service.QuestionServiceImpl;
import hu.transfet.unideb.application.model.questions.Question;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class GamePageController extends GameController implements Initializable {

    private int checkLastAnswer = 1;

    private Logger logger = LoggerFactory.getLogger(GamePageController.class);

    @FXML
    private ImageView bombImage;


    private int lastAnswer;
    private Question question;
    private String correctAnswer;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Line brownLine;

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
    private Label brownLabel;

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

        if (onClickLine(anchorPane, event, skyBlueLabel, correctAnswer, skyBlueLine))
            checkLastAnswer++;

        if (checkLastAnswer == lastAnswer) {
            if (lastAnswer == 7) {
                changeToNextGamePage(anchorPane, "/views/FinishSplash.fxml");
            } else {

                changeToNextGamePage(anchorPane, "/views/gamepages/GamePage.fxml");
            }
        }
    }

    @FXML
    void onClickedBrownLine(MouseEvent event) throws IOException {


        if (onClickLine(anchorPane, event, brownLabel, correctAnswer, brownLine))
            checkLastAnswer++;

        if (checkLastAnswer == lastAnswer) {
            if (lastAnswer == 7) {
                changeToNextGamePage(anchorPane, "/views/FinishSplash.fxml");
            } else {

                changeToNextGamePage(anchorPane, "/views/gamepages/GamePage.fxml");
            }
        }
    }


    @FXML
    void onClickedPinkLine(MouseEvent event) throws IOException {

        if (onClickLine(anchorPane, event, pinkLabel,correctAnswer, pinkLine))
            checkLastAnswer++;

        if (checkLastAnswer == lastAnswer) {
            if (lastAnswer == 7) {
                changeToNextGamePage(anchorPane, "/views/FinishSplash.fxml");
            } else {

                changeToNextGamePage(anchorPane, "/views/gamepages/GamePage.fxml");
            }
        }
    }

    @FXML
    void onClickedGreenLine(MouseEvent event) throws IOException {


       if (onClickLine(anchorPane, event, greenLabel, correctAnswer, greenLine))
            checkLastAnswer++;

        if (checkLastAnswer == lastAnswer) {
            if (lastAnswer == 7) {
                changeToNextGamePage(anchorPane, "/views/FinishSplash.fxml");
            } else {

                changeToNextGamePage(anchorPane, "/views/gamepages/GamePage.fxml");
            }
        }
    }

    @FXML
    void onClickedPurpleLine(MouseEvent event) throws IOException {

        if (onClickLine(anchorPane, event, purpleLabel, correctAnswer, purpleLine))
            checkLastAnswer++;

        if (checkLastAnswer == lastAnswer) {

            if (lastAnswer == 7) {
                changeToNextGamePage(anchorPane, "/views/FinishSplash.fxml");
            } else {

                changeToNextGamePage(anchorPane, "/views/gamepages/GamePage.fxml");
            }
        }

    }

    @FXML
    void onClickedOrangeLine(MouseEvent event) throws IOException {


        if (onClickLine(anchorPane, event, orangeLabel, correctAnswer, orangeLine))
            checkLastAnswer++;
        if (checkLastAnswer == lastAnswer) {
            if (lastAnswer == 7) {
                changeToNextGamePage(anchorPane, "/views/FinishSplash.fxml");
            } else {

                changeToNextGamePage(anchorPane, "/views/gamepages/GamePage.fxml");
            }
        }
    }

    @FXML
    void onClickedRedLine(MouseEvent event) throws IOException {


        if (onClickLine(anchorPane, event, redLabel, correctAnswer, redLine))
            checkLastAnswer++;
        if (checkLastAnswer == lastAnswer) {
            if (lastAnswer == 7) {
                changeToNextGamePage(anchorPane, "/views/FinishSplash.fxml");
            } else {

                changeToNextGamePage(anchorPane, "/views/gamepages/GamePage.fxml");
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void addLabelsAndLines(ArrayList<Pair<Label, Line>> labelsAndLines) {
        labelsAndLines.add(new Pair(purpleLabel, purpleLine));
        labelsAndLines.add(new Pair(greenLabel, greenLine));
        labelsAndLines.add(new Pair(orangeLabel, orangeLine));
        labelsAndLines.add(new Pair(redLabel, redLine));
        labelsAndLines.add(new Pair(skyBlueLabel, skyBlueLine));
        labelsAndLines.add(new Pair(pinkLabel, pinkLine));
        labelsAndLines.add(new Pair(brownLabel, brownLine));
    }

    private void setLabelsText(int limit, ArrayList<Pair<Label, Line>> labelsAndLines, List<Answer> answers) {

        List<Integer> randomNumbers = randomNumbers(limit, limit, false);

        questionLabel.setText(question.getQuestion());

        for (int i = 0; i < limit; i++) {
            labelsAndLines.get(randomNumbers.get(i)).getKey().setText(answers.get(i).getAnswer());
            labelsAndLines.get(randomNumbers.get(i)).getKey().setVisible(true);

            labelsAndLines.get(randomNumbers.get(i)).getValue().setVisible(true);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void initialize(URL location, ResourceBundle resources) {

        QuestionServiceImpl questionServiceImpl = ServiceLocator.getService(QuestionServiceImpl.class);
        if (!isFirstStart) {
            randomNumberForQuestion = randomNumbers((questionServiceImpl.findAllQuestion().size()), 6, true);
            isFirstStart = true;
        }

        int labelsNumber = GameController.getPageNumber() + 2;
        lastAnswer = labelsNumber;

        question = questionServiceImpl.findById(randomNumberForQuestion.get(labelsNumber - 2));

        //Question quest = questionServiceImpl.findById(1);
        List<Answer> answers = question.getAnswers();

        int correctAnswerIndex = question.getCorrectAnswerIndex();
        correctAnswer = answers.get(correctAnswerIndex).getAnswer();

        ArrayList<Pair<Label, Line>> labelsAndLines = new ArrayList<>();
        addLabelsAndLines(labelsAndLines);

        setLabelsText(labelsNumber,labelsAndLines,answers);

        labelsNumber++;
        GameController.setPageNumber(labelsNumber - 2);

        countDown(anchorPane, timeLabel);
    }

}
