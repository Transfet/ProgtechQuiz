package hu.transfet.unideb.application.controller;

import hu.transfet.unideb.application.Game;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 *.
 */
public class Controller {
    /**
     *.
     */
    private Logger logger = LoggerFactory.getLogger(Controller.class);

    /**
     * .
     * @param fxml .
     * @param event .
     */
    @SuppressWarnings("ConstantConditions")
    public void changeToScreen(String fxml, ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(fxml));
            Scene scene = new Scene(root);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();

        } catch (IOException ioe) {
            logger.error("Error: Cannot load the FXML file" + fxml);
            ioe.printStackTrace();
        }

    }

    /**
     * .
     * @param anchorPane .
     * @param fxmlName .
     * @return .
     */
    @SuppressWarnings("ConstantConditions")
    private AnchorPane getAnchorPaneFromFxml(AnchorPane anchorPane, String fxmlName) {
        AnchorPane pane;
        try {
            pane = FXMLLoader.load(getClass().getClassLoader().getResource(fxmlName));
            anchorPane.getChildren().setAll(pane);
            return pane;

        } catch (IOException ioe) {
            logger.error("Cannot load FXML datas from: " + fxmlName, ioe);
            ioe.printStackTrace();
        }
        return null;
    }

    /**
     * .
     * @param second .
     * @param pane .
     * @return .
     */
    private FadeTransition fadeInTransition(int second, AnchorPane pane) {
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(second), pane);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setCycleCount(1);

        return fadeIn;
    }

    /**
     * .
     * @param second .
     * @param pane .
     * @return .
     */
    private FadeTransition fadeOutTransition(int second, AnchorPane pane) {

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(second), pane);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setCycleCount(1);

        return fadeOut;
    }

    /**
     * .
     * @param anchorPane .
     * @param fromFxml .
     * @param toFxml .
     */
    public void loadSplashScreen(AnchorPane anchorPane, String fromFxml, String toFxml) {

        Game.isSplashLoaded = true;

        AnchorPane pane = getAnchorPaneFromFxml(anchorPane, fromFxml);

        FadeTransition fadeIn = fadeInTransition(2, pane);
        FadeTransition fadeOut = fadeOutTransition(2, pane);

        fadeIn.play();
        fadeIn.setOnFinished((e) -> fadeOut.play());
        fadeOut.setOnFinished((e) -> fadeOutFinished(anchorPane, toFxml));

    }

    /**
     * .
     * @param anchorPane .
     * @param toFxml .
     */
    @SuppressWarnings("ConstantConditions")
    private void fadeOutFinished(AnchorPane anchorPane, String toFxml) {
        getAnchorPaneFromFxml(anchorPane, toFxml);
    }
}
