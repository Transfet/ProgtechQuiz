package application.controller;

/**
 * Created by Transfet on 2017. 05. 05..
 */
        import java.io.IOException;
        import java.net.URL;
        import java.util.ResourceBundle;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.layout.Pane;
        import javafx.stage.Stage;


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


    public void launchGame(ActionEvent event) throws IOException {

        Stage prevStage = (Stage) startButton.getScene().getWindow();

        Stage stage = new Stage();
        stage.setTitle("Quiz Game");
        Pane myPane = null;

        myPane = FXMLLoader.load(getClass().getResource("/views/GamePage1.fxml"));
        Scene scene = new Scene(myPane);

        stage.setScene(scene);
        prevStage.close();
        stage.show();
        GamePage1Controller.init();

    }


    @FXML
    void onClickedStartButton(ActionEvent event) throws IOException {

        launchGame(event);

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
