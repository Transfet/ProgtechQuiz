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

public class GamePageOneController implements Initializable{

    private boolean isClickedOnBlueLine = false;
    private boolean isClickedOnRedLine = false;
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
    void onClickedRedLine(MouseEvent event) throws IOException{

        isClickedOnRedLine = true;

            if (!redLabel.getText().equals(firstQuestion.getAnswer())) {
                checkLastAnswer++;
                redLine.setStroke(Color.BLACK);
            }
            else
                gameOver();

            if(checkLastAnswer == 1){
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

            if(checkLastAnswer == 1){

                changeToNextGamePage(event);

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
            blueLine.setStroke(Color.BLUE);
        }

    }

    @FXML
    void cursorOverRedLine(MouseEvent event){
        if(!isClickedOnRedLine) {
            redLine.setStroke(Color.GRAY);
        }
    }

    @FXML
    void cursorNotOverRedLine(MouseEvent event){
        if(!isClickedOnRedLine)
          redLine.setStroke(Color.RED);
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


        Double ID = Math.random()*2 + 1;
        Double badAnswerId = Math.random()*2 +1 ;

        while(ID.equals(badAnswerId)){
            badAnswerId = Math.random()*2+1;
        }

        System.out.println(ID);
        System.out.println(badAnswerId.intValue());

        firstQuestion = questionService.findById((ID.intValue()));
        String badAnswer = questionService.findById(badAnswerId.intValue()).getAnswer();


       questionLabel.setText(firstQuestion.getQuestion());blueLabel.setText(firstQuestion.getAnswer());
       redLabel.setText(badAnswer);

    }

       private void changeToNextGamePage(MouseEvent event) throws IOException {

        String fromPage = "/views/NextGamePage.fxml";
        String toPage = "/views/gamepages/GamePageTwo.fxml";
        loadSplashScreen(fromPage,toPage);

    }
}
