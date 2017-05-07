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
import java.util.List;
import java.util.ResourceBundle;

public class GamePageThreeController implements Initializable{

    private boolean isClickedOnGreenLine = false;
    private boolean isClickedOnBlueLine = false;
    private boolean isClickedOnSkyBlueLine = false;
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
    void onClickedGreenLine(MouseEvent event) throws IOException{

        isClickedOnGreenLine = true;

        if (!greenLabel.getText().equals(firstQuestion.getAnswer())) {
            checkLastAnswer++;
            greenLine.setStroke(Color.BLACK);
        }
        else
            gameOver();

        if(checkLastAnswer == 2){
            changeToNextGamePage(event);
        }
    }

    @FXML
    void onClickedBlueLine(MouseEvent event)throws IOException {
        isClickedOnBlueLine = true;

        if (!blueLabel.getText().equals(firstQuestion.getAnswer())) {
            checkLastAnswer++;
            blueLine.setStroke(Color.BLACK);
        }
        else
            gameOver();

        if(checkLastAnswer == 2){

            changeToNextGamePage(event);

        }

    }

    @FXML
    void onClickedSkyBlueLine(MouseEvent event) throws IOException{

        isClickedOnSkyBlueLine = true;

        if (!skyBlueLabel.getText().equals(firstQuestion.getAnswer())) {
            checkLastAnswer++;
            skyBlueLine.setStroke(Color.BLACK);
        }
        else
            gameOver();

        if(checkLastAnswer == 2){
            changeToNextGamePage(event);
        }
    }


    @FXML
    void cursorOverSkyBlueLine(MouseEvent event){

        if(!isClickedOnSkyBlueLine){
            skyBlueLine.setStroke(Color.GRAY);
        }

    }

    @FXML
    void cursorNotOverSkyBlueLine(MouseEvent event){

        if(!isClickedOnSkyBlueLine){
            skyBlueLine.setStroke(Color.valueOf("#11c678"));
        }

    }

    @FXML
    void cursorOverBlueLine(MouseEvent event){

        if(!isClickedOnBlueLine){
            blueLine.setStroke(Color.GRAY);
        }

    }

    @FXML
    void cursorNotOverBlueLine(MouseEvent event){

        if(!isClickedOnBlueLine){
            blueLine.setStroke(Color.valueOf("#005eff"));
        }

    }

    @FXML
    void cursorOverGreenLine(MouseEvent event){
        if(!isClickedOnGreenLine) {
            greenLine.setStroke(Color.GRAY);
        }
    }

    @FXML
    void cursorNotOverGreenLine(MouseEvent event){
        if(!isClickedOnGreenLine)
            greenLine.setStroke(Color.valueOf("#3fff00"));
    }

    private void gameOver(){

        String fromFXML = "/views/GameOverSplash.fxml";
        String toFXML = "/views/Result.fxml";

        loadSplashScreen(fromFXML,toFXML);

    }

    private void loadSplashScreen(String fromFxml, String toFxml) {
        try {

            Game.isSplashLoaded = true;

            AnchorPane pane = FXMLLoader.load(getClass().getResource(fromFxml));
            anchorPane.getChildren().setAll(pane);

            FadeTransition fadeIn = new FadeTransition(Duration.seconds(2), pane);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(1);

            FadeTransition fadeOut = new FadeTransition(Duration.seconds(2), pane);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setCycleCount(1);

            fadeIn.play();

            fadeIn.setOnFinished((e) -> fadeOut.play());

            fadeOut.setOnFinished((e) -> fadeOutFinished(toFxml));

        } catch (IOException e) {
            logger.error("Throw by IOException in loadSplash method : ", e);
        }
    }

    private void fadeOutFinished(String toFxml){
        try {
            AnchorPane parentContent = FXMLLoader.load(getClass().getResource((toFxml)));
            anchorPane.getChildren().setAll(parentContent);

        } catch (IOException ex) {
            logger.error("Throw by IOException in fadeOutFinished method: ", ex);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        questionService = ServiceLocator.getService(QuestionService.class);


        Double ID = Math.random()*6 + 1;
        Double badAnswerId = Math.random()*6 +1;
        Double badAnswer2Id = Math.random()*6+1;

        while(badAnswerId.equals(badAnswer2Id)) {
            badAnswer2Id = Math.random() * 6 + 1;
        }

        System.out.println(badAnswerId.intValue());

        firstQuestion = questionService.findById((ID.intValue()));
        String badAnswer = questionService.findById(badAnswerId.intValue()).getAnswer();
        String badAnswer2 = questionService.findById(badAnswer2Id.intValue()).getAnswer();


        questionLabel.setText(firstQuestion.getQuestion());

        blueLabel.setText(firstQuestion.getAnswer());
        greenLabel.setText(badAnswer);
        skyBlueLabel.setText(badAnswer2);

    }

    private void changeToNextGamePage(MouseEvent event) throws IOException {

        String fromPage = "/views/NextGamePage.fxml";
        String toPage = "/views/gamepages/GamePageThree.fxml";
        loadSplashScreen(fromPage,toPage);

    }
}
