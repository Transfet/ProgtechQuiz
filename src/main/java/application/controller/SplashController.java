package application.controller;


import application.ServiceLocator;
import application.database.PlayerService;
import application.model.player.Player;
import javafx.fxml.Initializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Transfet on 2017. 05. 05..
 */
public class SplashController implements Initializable{

    PlayerService playerService;

    Logger logger = LoggerFactory.getLogger(SplashController.class);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        playerService = ServiceLocator.getService(PlayerService.class);



    }
}
