package application.database;

import application.model.player.Player;
import application.model.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Transfet on 2017. 05. 03..
 */

@Service
public class PlayerService implements PlayerServiceInterface {

    //final static Logger logger = LoggerFactory.getLogger(PlayerService.class);

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Player> findAllPlayer() {
        return playerRepository.findAll();
    }

    @Override
    public void addPlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    public void deletePlayer(Player player) {

        playerRepository.delete(player);
    }

    @Override
    public List<Player> findByMaxPoints() {
        //return null;
        return playerRepository.findAllAndSort();
    }


    @Override
    public void updatePlayerPointAndTime(String player, Double point, Double time) {
        playerRepository.updatePlayerPointAndTime(player, point, time);
    }
}
