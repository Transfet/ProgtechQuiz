package application.database;

import application.model.player.Player;
import application.model.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p>Egy osztaly,mely implementalja a {@link PlayerServiceInterface}
 * Ezen osztaly metodusaival tudunk a jatekosokhoz hozzaferni, illetve modositani az adatbazisban.</p>
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
    public void updatePlayerPointAndTime(String player, Double point, Double time) {
        playerRepository.updatePlayerPointAndTime(player, point, time);
    }


    @Override
    public Player findById(Long iD) {
        return playerRepository.findPlayerById(iD);
    }

}
