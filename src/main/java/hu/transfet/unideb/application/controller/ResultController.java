package hu.transfet.unideb.application.controller;

import hu.transfet.unideb.application.ServiceLocator;
import hu.transfet.unideb.application.controller.logincontrollers.LoggedInController;
import hu.transfet.unideb.application.service.PlayerServiceImpl;
import hu.transfet.unideb.application.model.player.Player;
import hu.transfet.unideb.application.model.player.PlayerResult;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

/**
 *.
 */
public class ResultController extends Controller implements Initializable {
    /**
     *.
     */
    @FXML
    private TableColumn playerColumn;
    /**
     *.
     */
    @FXML
    private TableColumn pointColumn;
    /**
     *.
     */
    @FXML
    private TableColumn timeColumn;
    /**
     *.
     */
    @FXML
    private Button quitButton;
    /**
     *.
     */
    @FXML
    private Button restartButton;
    /**
     *.
     */
    @FXML
    private TableView<PlayerResult> resultTable;
    /**
     *.
     */
    private ObservableList<PlayerResult> data;
    /**
     *.
     */
    private PlayerServiceImpl playerService;

    /**
     * .
     * @param event .
     */
    @FXML
    void onClickedRestartButton(ActionEvent event){

        changeToScreen("GamePage.fxml", event);

    }
    /**
     * .
     * @param event .
     */
    @FXML
    void onClickedBackButton(ActionEvent event){

        changeToScreen("LoggedInPage.fxml", event);

    }
    /**
     * .
     * @param event .
     */
    @FXML
    void onClickedQuitButton(ActionEvent event){

        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();

    }

    /**
     * .
     */
    @SuppressWarnings("unchecked")
    private void setCellValues(){

        playerColumn.setCellValueFactory(new PropertyValueFactory<PlayerResult, String>("username"));
        pointColumn.setCellValueFactory(new PropertyValueFactory<PlayerResult, Double>("point"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<PlayerResult, Double>("time"));
    }
    /**
     * .
     */
    private void checkIsLastPageLoggedIn(){

        if (LoggedInController.fromLoggedIn) {
            restartButton.setVisible(false);
        } else {
            restartButton.setVisible(true);
        }

    }
    /**
     * .
     */
    private void prepareTable(){

        checkIsLastPageLoggedIn();
        data = FXCollections.observableArrayList();

        setCellValues();
    }
    /**
     * .
     */
    private void populateTable(){

        for (Player p : playerService.findAllPlayer()) {
            PlayerResult res = new PlayerResult(p.getUserName(), p.getPoints(), p.getTime());
            data.add(res);

        }

        data.sort(Comparator.comparing(PlayerResult::getPoint).reversed());
        resultTable.setItems(null);
        resultTable.setItems(data);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playerService = ServiceLocator.getService(PlayerServiceImpl.class);

        prepareTable();
        populateTable();

    }
}
