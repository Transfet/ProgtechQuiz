package hu.transfet.unideb.application.controller.gamecontrollers;

import hu.transfet.unideb.application.ServiceLocator;
import hu.transfet.unideb.application.model.answer.Answer;
import hu.transfet.unideb.application.service.QuestionServiceImpl;
import hu.transfet.unideb.application.model.questions.Question;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.util.Pair;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class GamePageController extends GameController implements Initializable {

    private int checkLastAnswer = 1;

    private int lastAnswer;
    private Question question;
    private String correctAnswer;
    private ArrayList<Pair<Label, Line>> labelsAndLines;
    private List<Answer> answers;
    private List<Integer> randomNumbersForLabels;

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

        if (onClickLine(skyBlueLabel, skyBlueLine))
            checkLastAnswer++;

        checkAnswer(checkLastAnswer);
    }

    @FXML
    void onClickedBrownLine(MouseEvent event) throws IOException {

        if (onClickLine(brownLabel, brownLine))
            checkLastAnswer++;

        checkAnswer(checkLastAnswer);
    }

    @FXML
    void onClickedPinkLine(MouseEvent event) throws IOException {

        if (onClickLine(pinkLabel, pinkLine))
            checkLastAnswer++;

        checkAnswer(checkLastAnswer);
    }

    @FXML
    void onClickedGreenLine(MouseEvent event) throws IOException {

        if (onClickLine(greenLabel, greenLine))
            checkLastAnswer++;

        checkAnswer(checkLastAnswer);
    }

    @FXML
    void onClickedPurpleLine(MouseEvent event) throws IOException {

        if (onClickLine(purpleLabel, purpleLine))
            checkLastAnswer++;

        checkAnswer(checkLastAnswer);
    }

    @FXML
    void onClickedOrangeLine(MouseEvent event) throws IOException {

        if (onClickLine(orangeLabel, orangeLine))
            checkLastAnswer++;

        checkAnswer(checkLastAnswer);

    }

    @FXML
    void onClickedRedLine(MouseEvent event) throws IOException {

        if (onClickLine(redLabel, redLine))
            checkLastAnswer++;

        checkAnswer(checkLastAnswer);

    }

    private void checkAnswer(int answerCounter) throws IOException {

        if (checkLastAnswer == lastAnswer) {
            if (lastAnswer == 7) {
                changeToNextGamePage(anchorPane, "FinishSplash.fxml");
            } else {

                changeToNextGamePage(anchorPane, "GamePage.fxml");
            }
        }

    }

    private boolean onClickLine(Label label, Line line) {

        if (!label.getText().equals(correctAnswer)) {
            line.setVisible(false);
            label.setVisible(false);
            return true;
        } else {
            gameOver(anchorPane);
            return false;
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

    private void setVisibleToLabelAndLine(int index) {
        labelsAndLines.get(randomNumbersForLabels.get(index)).getKey().setText(answers.get(index).getAnswer());
        labelsAndLines.get(randomNumbersForLabels.get(index)).getKey().setVisible(true);
        labelsAndLines.get(randomNumbersForLabels.get(index)).getValue().setVisible(true);
    }

    private void setLabelsText(int limit) {

        questionLabel.setText(question.getQuestion());
        for (int i = 0; i < limit; i++) {
            setVisibleToLabelAndLine(i);
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
        randomNumbersForLabels = randomNumbers(labelsNumber, labelsNumber, false);
        lastAnswer = labelsNumber;

        question = questionServiceImpl.findById(randomNumberForQuestion.get(labelsNumber - 2));

        labelsAndLines = new ArrayList<>();
        answers = question.getAnswers();

        int correctAnswerIndex = question.getCorrectAnswerIndex();
        correctAnswer = answers.get(correctAnswerIndex).getAnswer();

        addLabelsAndLines(labelsAndLines);
        setLabelsText(labelsNumber);

        labelsNumber++;
        GameController.setPageNumber(labelsNumber - 2);

        countDown(anchorPane, timeLabel);
    }

}
