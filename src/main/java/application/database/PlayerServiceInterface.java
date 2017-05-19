package application.database;

import application.model.player.Player;

import java.util.List;

/**
 * {@link PlayerService}
 * @see Player
 */
public interface PlayerServiceInterface {

    /**
     * Added a player to the database
     *
     * @param player
     */
    void addPlayer(Player player);

    /**
     * Delete a player from database
     *
     * @param player
     */
    void deletePlayer(Player player);

    /**
     * return all player from database
     * @return list which contain players
     */
    List<Player> findAllPlayer();

    /**
     * return all player from database order by points
     *
     * @return list which contain players
     */
    List<Player> findByMaxPoints();

    Player findById(Long iD);

    Player findPlayerByFirstName(String name);

    void updatePlayerPointAndTime(String player, Double point, Double time);

}
