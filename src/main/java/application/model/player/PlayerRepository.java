package application.model.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * Created by Transfet on 2017. 04. 29..<
 */


public interface PlayerRepository extends JpaRepository<Player, Long> {

     @Query("select p from Player p order by p.points desc ")
     List<Player> findAllAndSort();

}
