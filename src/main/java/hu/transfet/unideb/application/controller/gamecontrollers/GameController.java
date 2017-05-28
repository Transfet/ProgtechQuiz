package hu.transfet.unideb.application.controller.gamecontrollers;

import hu.transfet.unideb.application.ServiceLocator;
import hu.transfet.unideb.application.controller.Controller;
import hu.transfet.unideb.application.controller.logincontrollers.SignInController;
import hu.transfet.unideb.application.service.PlayerServiceImpl;
import hu.transfet.unideb.application.model.player.Player;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * .
 */
public class GameController extends Controller {

    /**
     * .
     */
    public static boolean isFirstStart = false;
    /**
     * .
     */
    private final int STARTTIME = 60;
    /**
     * .
     */
    private int timeSecond;
    /**
     * .
     */
    private Timeline timeline;
    /**
     * .
     */
    private static int pageNumber = 0;

    /**
     * .
     */
    private Player signedInPlayer = SignInController.getSignedInPlayer();
    /**
     * .
     */
    private PlayerServiceImpl playerService = ServiceLocator.getService(PlayerServiceImpl.class);
    /**
     * .
     */
    public static List<Integer> randomNumberForQuestion;

    /**
     * .
     * @param pageNumb .
     */
    public static void setPageNumber(int pageNumb) {
        pageNumber = pageNumb;
    }

    /**
     * .
     * @return .
     */
    public static int getPageNumber() {
        return pageNumber;
    }

    /**
     * .
     * @param size .
     * @param neededNumbers .
     * @param fromOne .
     * @return .
     */
    public List<Integer> randomNumbers(int size, int neededNumbers, boolean fromOne) {

        Random random = new Random();
        int count = 0;
        int num;

        List<Integer> randomNumbers = new ArrayList<>();

        while (count < neededNumbers) {
            if (fromOne) {
                num = random.nextInt(size) + 1;
            } else {
                num = random.nextInt(size);
            }
            if (!randomNumbers.contains(num)) {
                randomNumbers.add(num);
                count++;
            }
        }
        return randomNumbers;

    }

    /**
     * .
     */
    private void updatePlayerResult() {

        double weight = STARTTIME - timeSecond;
        double time = signedInPlayer.getTime();
        time += weight;

        signedInPlayer.setTime(time);

        double point = signedInPlayer.getPoints();
        point += 20.0 * time;
        signedInPlayer.setPoints(point);

        playerService.updatePlayerPointAndTime(signedInPlayer.getUserName(), signedInPlayer.getPoints(), signedInPlayer.getTime());

    }

    /**
     * .
     * @param anchorPane .
     * @param to .
     * @throws IOException .
     */
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

    /**
     * .
     * @param anchorPane .
     */
    public void gameOver(AnchorPane anchorPane) {

        timeline.stop();

        String fromFXML = "GameOverSplash.fxml";
        String toFXML = "Result.fxml";
        isFirstStart = false;
        pageNumber = 0;
        loadSplashScreen(anchorPane, fromFXML, toFXML);

    }

    /**
     * .
     * @param anchorPane .
     * @param timeLabel .
     */
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

    /**
     * .
     * @param anchorPane .
     * @param label .
     */
    private void addFrame(AnchorPane anchorPane, Label label) {
        timeSecond--;

        label.setText(Integer.toString(timeSecond));

        if (timeSecond <= 0) {
            timeline.stop();
            gameOver(anchorPane);
        }
    }

}
