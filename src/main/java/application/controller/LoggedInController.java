package application.controller;

/**
 * Created by Transfet on 2017. 05. 05..
 */
        import java.net.URL;
        import java.util.ResourceBundle;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;


public class LoggedInController {

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


    @FXML
    void onClickedStartButton(ActionEvent event) {
    }

    @FXML
    void onClickedQuitButton(ActionEvent event) {
    }


    @FXML
    void initialize() {
        assert quitButton != null : "fx:id=\"quitButton\" was not injected: check your FXML file 'LoggedInPage.fxml'.";
        assert startButton != null : "fx:id=\"startButton\" was not injected: check your FXML file 'LoggedInPage.fxml'.";
        assert statusLabel != null : "fx:id=\"statusLabel\" was not injected: check your FXML file 'LoggedInPage.fxml'.";


    }

}
