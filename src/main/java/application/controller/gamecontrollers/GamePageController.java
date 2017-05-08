package application.controller.gamecontrollers;

import application.Game;
import application.ServiceLocator;
import application.controller.logincontrollers.SignInController;
import application.database.PlayerService;
import application.model.player.Player;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * Created by Transfet on 2017. 05. 07..
 */
public class GamePageController {

    private AnchorPane anchorPane;
    private double point = 0.0;
    private double weight = 0.0;
    private double time = 0.0;
    private final int STARTTIME = 10;
    private int timeSecond;
    private boolean changeScreen = false;
    private Timeline timeline;

    private Player signedInPlayer = SignInController.getSignedInPlayer();
    private PlayerService playerService = ServiceLocator.getService(PlayerService.class);

    public List<Integer> randomNumbers(int size, int neededNumbers, boolean fromOne) {

        Random random = new Random();
        int count = 0;
        int num;
        List<Integer> randomNumbers = new ArrayList<Integer>();
        if (fromOne) {
            while (count < neededNumbers) {
                num = random.nextInt(size) + 1;
                if (!randomNumbers.contains(num)) {
                    randomNumbers.add(num);
                    count++;
                }
            }
        } else {
            while (count < neededNumbers) {
                num = random.nextInt(size);
                if (!randomNumbers.contains(num)) {
                    randomNumbers.add(num);
                    count++;
                }
            }
        }


        for (Integer intig : randomNumbers)
            System.out.println(intig.toString());

        return randomNumbers;
    }

    public void loadSplashScreen(AnchorPane anchorPane, String fromFxml, String toFxml) {
        try {
            Game.isSplashLoaded = true;

            AnchorPane pane = FXMLLoader.load(getClass().getResource(fromFxml));
            anchorPane.getChildren().setAll(pane);

            this.anchorPane = anchorPane;

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
            // logger.error("Throw by IOException in loadSplash method : ", e);
        }
    }

    private void fadeOutFinished(String toFxml) {
        try {
            AnchorPane parentContent = FXMLLoader.load(getClass().getResource((toFxml)));
            anchorPane.getChildren().setAll(parentContent);

        } catch (IOException ex) {
            //logger.error("Throw by IOException in fadeOutFinished method: ", ex);
        }
    }

    public void changeToNextGamePage(AnchorPane anchorPane, String to) throws IOException {

        changeScreen = true;
        weight = timeSecond;
        time = signedInPlayer.getTime();
        time += timeSecond;
        signedInPlayer.setTime(time);

        signedInPlayer.setTime(time);
        point = signedInPlayer.getPoints();
        point += 30.0*time;
        signedInPlayer.setPoints(point);

        playerService.updatePlayerPointAndTime(signedInPlayer.getUserName(), signedInPlayer.getPoints(), signedInPlayer.getTime());
        System.out.println(signedInPlayer);
        String fromPage = "/views/NextGamePage.fxml";
        loadSplashScreen(anchorPane, fromPage, to);

    }

    public void gameOver(AnchorPane anchorPane) {

        System.out.println(signedInPlayer);
        String fromFXML = "/views/GameOverSplash.fxml";
        String toFXML = "/views/Result.fxml";
        loadSplashScreen(anchorPane, fromFXML, toFXML);

    }

    public void countDown(AnchorPane anchorPane,Label timeLabel){

        if(timeline != null){
            timeline.stop();
        }
        timeSecond = STARTTIME;

        timeLabel.setText(Integer.toString(timeSecond));
        timeline = new Timeline();

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1),event -> addFrame(anchorPane,timeLabel)));

        timeline.playFromStart();

    }

    private void addFrame(AnchorPane anchorPane,Label label){
        timeSecond--;

        label.setText(Integer.toString(timeSecond));

        System.out.println(timeSecond);

        if(timeSecond <= 0){
            timeline.stop();
            gameOver(anchorPane);
        }

        if(changeScreen){
            timeline.stop();
        }

    }

}
