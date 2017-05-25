package hu.transfet.unideb.application.service;

import hu.transfet.unideb.application.model.player.Player;

import java.util.List;

/**
 * Jatekos-kezelest megvalosito interfesz , melyet {@link PlayerServiceImpl}}
 * implemental.
 *
 * @see Player
 */
public interface PlayerService {

    /**
     * Hozzaad egy jatekost az adatbazisunkhoz.
     * @param player egy jatekos.
     */
    void addPlayer(Player player);

    /**
     * Kitorol egy jatekost az adatbazisbol.
     * @param player egy jatekos.
     */
    void deletePlayer(Player player);

    /**
     * Listazza az adatbazisban levo osszes jatekost.
     * @return jatekosokat tartalmazo lista
     */

    List<Player> findAllPlayer();


    /**
     * Megkeres egy jatekost, az adatbazisban szereplo ID-je alapjan.
     *
     * @param iD Az adatbazisban szereplo jatekos ID-je
     * @return Egy jatekos
     */
    Player findById(Long iD);

    /**
     * Frissiti az adatbazisban a jatekos pontszamat, es az idejet.
     *
     * @param player Egy jatekos
     * @param point Aktualis pontszam
     * @param time Aktualis ido, mely ido alatt fejezte be a jatekot.
     */
    void updatePlayerPointAndTime(String player, Double point, Double time);

}
