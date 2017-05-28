package hu.transfet.unideb.application.controller.logincontrollers;

import java.net.URL;
import java.util.ResourceBundle;

import hu.transfet.unideb.application.controller.Controller;
import hu.transfet.unideb.application.model.player.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * .
 */
public class LoggedInController extends Controller implements Initializable {
    /**
     * .
     */
    private Logger logger = LoggerFactory.getLogger(LoggedInController.class);
    /**
     * .
     */
    @FXML
    private Button quitButton;
    /**
     * .
     */
    @FXML
    private Label signedInLabel;
    /**
     * .
     */
    private static Player signedInPlayer;
    /**
     * .
     */
    public static boolean fromLoggedIn = false;

    /**
     * .
     * @param event .
     */
    @FXML
    void onClickedStartButton(ActionEvent event){

        changeToScreen("GamePage.fxml", event);

    }
    /**
     * .
     * @param event .
     */
    @FXML
    void onClickedSignOutButton(ActionEvent event){

        signedInPlayer = null;
        changeToScreen("SignInPage.fxml", event);

    }
    /**
     * .
     * @param event .
     */
    @FXML
    void onClickedQuitButton(ActionEvent event) {

        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();

    }
    /**
     * .
     * @param event .
     */
    @FXML
    void onClickedTableButton(ActionEvent event){
        fromLoggedIn = true;
        changeToScreen("Result.fxml", event);
    }

    /**
     *  .
     * @param location .
     * @param resources .
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        signedInPlayer = SignInController.getSignedInPlayer();
        logger.info("Signed as: " + signedInPlayer.toString());

        signedInLabel.setText("Welcome: " + signedInPlayer.getUserName());
    }

}
