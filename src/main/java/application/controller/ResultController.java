package application.controller;

import application.ServiceLocator;
import application.database.PlayerService;
import application.model.player.Player;
import application.model.player.PlayerResult;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Transfet on 2017. 05. 06..
 */
public class ResultController implements Initializable {

    private PlayerService playerService;

    @FXML
    private TableColumn playerColumn;

    @FXML
    private TableColumn pointColumn;

    @FXML
    private TableColumn timeColumn;

    @FXML
    private TableView<PlayerResult> resultTable;

    private ObservableList<PlayerResult> data;

    @Override
    @SuppressWarnings("unchecked")
    public void initialize(URL location, ResourceBundle resources) {

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
