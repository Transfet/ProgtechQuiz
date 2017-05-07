package application.database;

import application.model.player.Player;

import java.util.List;

/**
 * Created by Transfet on 2017. 05. 03..
 */
public interface PlayerServiceInterface {

    /**
     * Hozzáadja a felhasználót az adatbázishoz
     *
     * @param player egy  felhasználót tartalmazó objektum
     */
    void addPlayer(Player player);

    /**
     * Eltávolít egy felhasználót az adatbázisból
     *
     * @param player egy felhaszanlót tartalmazó objektum
     */
    void deletePlayer(Player player);

    /**
     * Visszaadja az adatbázisban szereplő összes felhasználót
     *
     * @return list egy felhasználókat tartalmazó lista
     */
    List<Player> findAllPlayer();

    /**
     * Visszaadja az adatbázisban szereplő összes felhasználót pontszám szerint növekvő sorrendben
     *
     * @return list egy felhasználókat tartalmazó lista
     */
    List<Player> findByMaxPoints();

    void updatePlayerPoint(String player, Double point);

}
