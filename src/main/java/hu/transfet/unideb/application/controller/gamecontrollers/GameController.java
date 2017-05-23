package hu.transfet.unideb.application.controller.gamecontrollers;

import hu.transfet.unideb.application.Game;
import hu.transfet.unideb.application.ServiceLocator;
import hu.transfet.unideb.application.controller.logincontrollers.SignInController;
import hu.transfet.unideb.application.service.PlayerServiceImpl;
import hu.transfet.unideb.application.model.player.Player;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameController {


    private AnchorPane anchorPane;
    public static boolean isFirstStart = false;
    private final int STARTTIME = 60;
    private int timeSecond;
    private Timeline timeline;
    private static int pageNumber = 0;

    private Logger logger = LoggerFactory.getLogger(GameController.class);
    private Player signedInPlayer = SignInController.getSignedInPlayer();
    private PlayerServiceImpl playerService = ServiceLocator.getService(PlayerServiceImpl.class);
    public static List<Integer> randomNumberForQuestion;


    public static void setPageNumber(int pageNumb) {
        pageNumber = pageNumb;
    }

    public static int getPageNumber() {
        return pageNumber;
    }

    public List<Integer> randomNumbers(int size, int neededNumbers, boolean fromOne) {

        Random random = new Random();
        int count = 0;
        int num;
        List<Integer> randomNumbers = new ArrayList<>();
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
            logger.info("numbers: " + Integer.toString(intig));

        logger.info("size: " + Integer.toString(randomNumbers.size()));

        return randomNumbers;
    }

    @SuppressWarnings("ConstantConditions")
    private AnchorPane getAnchorPaneFromFxml(AnchorPane anchorPane,String fxmlName){
        AnchorPane pane;
        try{
            pane = FXMLLoader.load(getClass().getClassLoader().getResource(fxmlName));
            anchorPane.getChildren().setAll(pane);
            return pane;

        }catch (IOException ioe){
            logger.error("Cannot load FXML datas from: "+fxmlName, ioe);
            ioe.printStackTrace();
        }
        return null;
    }

    private FadeTransition fadeInTransition(int second,AnchorPane pane){
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(second), pane);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setCycleCount(1);

        return fadeIn;
    }

    private FadeTransition fadeOutTransition(int second,AnchorPane pane){
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(second), pane);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setCycleCount(1);

        return fadeOut;
    }

    public void loadSplashScreen(AnchorPane anchorPane, String fromFxml, String toFxml) {

            Game.isSplashLoaded = true;
            this.anchorPane = anchorPane;

            AnchorPane pane = getAnchorPaneFromFxml(anchorPane,fromFxml);

            FadeTransition fadeIn = fadeInTransition(2,pane);
            FadeTransition fadeOut = fadeOutTransition(2,pane);

            fadeIn.play();
            fadeIn.setOnFinished((e) -> fadeOut.play());
            fadeOut.setOnFinished((e) -> fadeOutFinished(toFxml));

    }

    @SuppressWarnings("ConstantConditions")
    private void fadeOutFinished(String toFxml) {
        try {
            AnchorPane parentContent = FXMLLoader.load(getClass().getClassLoader().getResource((toFxml)));
            anchorPane.getChildren().setAll(parentContent);

        } catch (IOException ex) {
            logger.error("Cannot load FXML datas from: " + toFxml, ex);
            ex.printStackTrace();
        }
    }

    private void updatePlayerResult(){

        double weight = STARTTIME - timeSecond;
        double time = signedInPlayer.getTime();
        time += weight;

        signedInPlayer.setTime(time);

        double point = signedInPlayer.getPoints();
        point += 20.0 * time;
        signedInPlayer.setPoints(point);

        playerService.updatePlayerPointAndTime(signedInPlayer.getUserName(), signedInPlayer.getPoints(), signedInPlayer.getTime());


    }

    public void changeToNextGamePage(AnchorPane anchorPane, String to) throws IOException {

        String fromPage;
        String toPage = to;
        timeline.stop();

        updatePlayerResult();

        if (to.equals("FinishSplash.fxml")) {

            fromPage = "FinishSplash.fxml";
            toPage = "Result.fxml";
            pageNumber = 0;
            isFirstStart = false;

        } else {
            fromPage = "NextGamePage.fxml";
        }

        loadSplashScreen(anchorPane, fromPage, toPage);

    }

    public void gameOver(AnchorPane anchorPane) {

        timeline.stop();

        System.out.println(signedInPlayer);
        String fromFXML = "GameOverSplash.fxml";
        String toFXML = "Result.fxml";
        isFirstStart = false;
        pageNumber = 0;
        loadSplashScreen(anchorPane, fromFXML, toFXML);

    }

    public void countDown(AnchorPane anchorPane, Label timeLabel) {

        if (timeline != null) {
            timeline.stop();
        }
        timeSecond = STARTTIME;

        timeLabel.setText(Integer.toString(timeSecond));
        timeline = new Timeline();

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), event -> addFrame(anchorPane, timeLabel)));

        timeline.playFromStart();

    }

    private void addFrame(AnchorPane anchorPane, Label label) {
        timeSecond--;

        label.setText(Integer.toString(timeSecond));

        //   logger.info(Double.toString(timeSecond));

        if (timeSecond <= 0) {
            timeline.stop();
            gameOver(anchorPane);
        }
    }

}
