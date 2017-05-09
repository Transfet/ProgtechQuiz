package application.controller;

import application.ServiceLocator;
import application.controller.logincontrollers.Controller;
import application.controller.logincontrollers.LoggedInController;
import application.database.PlayerService;
import application.model.player.Player;
import application.model.player.PlayerResult;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Transfet on 2017. 05. 06..
 */
public class ResultController extends Controller implements Initializable {

    private PlayerService playerService;

    @FXML
    private TableColumn playerColumn;

    @FXML
    private TableColumn pointColumn;

    @FXML
    private TableColumn timeColumn;

    @FXML
    private Button quitButton;

    @FXML
    private Button restartButton;

    @FXML
    private Button backButton;

    @FXML
    private TableView<PlayerResult> resultTable;

    private ObservableList<PlayerResult> data;


    @FXML
    void onClickedRestartButton(ActionEvent event) throws IOException{

        changeToScreen("/views/gamepages/GamePageOne.fxml",event);

    }

    @FXML
    void onClickedBackButton(ActionEvent event) throws IOException{

        changeToScreen("/views/loginpages/LoggedInPage.fxml",event);

    }

    @FXML
    void onClickedQuitButton(ActionEvent event) throws IOException{

        Stage stage = (Stage) quitButton.getScene().getWindow();
         stage.close();

    }


    @Override
    @SuppressWarnings("unchecked")
    public void initialize(URL location, ResourceBundle resources) {

        boolean checkValid = false;

        if(LoggedInController.fromLoggedIn){
            restartButton.setVisible(false);
        }
        else
        {
            restartButton.setVisible(true);
        }

        playerService = ServiceLocator.getService(PlayerService.class);

        data = FXCollections.observableArrayList();

        playerColumn.setCellValueFactory(new PropertyValueFactory<PlayerResult, String>("username"));

        pointColumn.setCellValueFactory(new PropertyValueFactory<PlayerResult, Double>("point"));

        timeColumn.setCellValueFactory(new PropertyValueFactory<PlayerResult, Double>("time"));

        for (Player p : playerService.findAllPlayer()) {

            System.out.println(p);
            PlayerResult res = new PlayerResult(p.getUserName(), p.getPoints(), p.getTime());

            data.add(res);

                }

        resultTable.setItems(null);
        resultTable.setItems(data);

    }
}
