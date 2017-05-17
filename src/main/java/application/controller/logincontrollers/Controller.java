package application.controller.logincontrollers;

import application.Game;
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


public class Controller {

    Logger logger = LoggerFactory.getLogger(Controller.class);

    public void changeToScreen(String fxml, ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Scene scene = new Scene(root);

        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);

        appStage.show();
    }

    public void loadSplashScreen(AnchorPane anchorPane) {
        try {
            Game.isSplashLoaded = true;

            AnchorPane pane = FXMLLoader.load(getClass().getResource("/views/Splash.fxml"));
            anchorPane.getChildren().setAll(pane);

            FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), pane);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(1);

            FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), pane);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setCycleCount(1);

            fadeIn.play();

            fadeIn.setOnFinished((e) -> fadeOut.play());

            fadeOut.setOnFinished((e) -> fadeOutFinished(anchorPane));

        } catch (IOException e) {
            logger.error("Throw by IOException in loadSplash method : ", e);
        }
    }

    private void fadeOutFinished(AnchorPane anchorPane) {
        try {
            AnchorPane parentContent = FXMLLoader.load(getClass().getResource(("/views/loginpages/SignInPage.fxml")));
            anchorPane.getChildren().setAll(parentContent);

        } catch (IOException ex) {
            logger.error("Throw by IOException in fadeOutFinished method: ", ex);
        }
    }
}
