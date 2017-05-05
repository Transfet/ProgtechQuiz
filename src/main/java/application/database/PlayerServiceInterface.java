package application.database;

import application.model.player.Player;

import java.util.List;

/**
 * Created by Transfet on 2017. 05. 03..
 */
public interface PlayerServiceInterface {

    void addPlayer(Player player);
    void deletePlayer(Player player);
    List<Player> findAllPlayer();
    List<Player> findByMaxPoints();

}
