package application.controller.logincontrollers;

/**
 * Created by Transfet on 2017. 05. 05..
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class LoggedInController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button quitButton;

    @FXML
    private Button startButton;

    @FXML
    private Label statusLabel;


    private void launchGame(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/views/gamepages/GamePageOne.fxml"));
        Scene scene = new Scene(root);

        Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        appStage.setScene(scene);

        appStage.show();
    }


    @FXML
    void onClickedStartButton(ActionEvent event) throws IOException {

        launchGame(event);

    }

    @FXML
    void onClickedQuitButton(ActionEvent event) {

        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

}
