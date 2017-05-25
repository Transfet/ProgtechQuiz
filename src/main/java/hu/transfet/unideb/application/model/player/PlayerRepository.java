package hu.transfet.unideb.application.model.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * PlayerRepository interfesz.
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

     /**
      * Visszad egy jatekost az adatbazis tablaban levo ID-je alapjan.
      * @param ID Egy Long ertek, mely a jatekos ID-jet szemlelteti.
      * @return Egy jatekos melyenk az ID-je a paramterkent kapott ID.
      */
     Player findPlayerById(Long ID);

     /**
      * Frissiti a jatekos pontszamat es idejet az adatbazis tablaban.
      * @param username A jatekos felhasznlo neve.
      * @param point A jatekos uj pontszama.
      * @param time A jatekos uj ideje.
      */
     @Transactional
     @Modifying(clearAutomatically = true)
     @Query("update Player p set p.points = :point,p.time = :time where p.userName = :user")
     void updatePlayerPointAndTime(@Param("user") String username, @Param("point") Double point, @Param("time") Double time);

}
