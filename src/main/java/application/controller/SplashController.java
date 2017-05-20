package application.controller;


import application.ServiceLocator;
import application.database.PlayerService;
import javafx.fxml.Initializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ResourceBundle;


public class SplashController implements Initializable{

    PlayerService playerService;

    Logger logger = LoggerFactory.getLogger(SplashController.class);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        playerService = ServiceLocator.getService(PlayerService.class);



    }
}
