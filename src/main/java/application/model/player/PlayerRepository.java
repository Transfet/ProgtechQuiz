package application.model.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface PlayerRepository extends JpaRepository<Player, Long> {

     @Query("select p from Player p order by p.points desc ")
     List<Player> findAllAndSort();

     @Transactional
     @Modifying(clearAutomatically = true)
     @Query("update Player p set p.points = :point,p.time = :time where p.userName = :user")
     void updatePlayerPointAndTime(@Param("user") String username, @Param("point") Double point, @Param("time") Double time);

}
