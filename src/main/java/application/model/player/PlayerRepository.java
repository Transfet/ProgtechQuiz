package application.model.player;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Transfet on 2017. 04. 29..<
 */


public interface PlayerRepository extends JpaRepository<Player,Long> {

   // List<Player> findAllByUserNameAndPointsOrderByPointsAsc();

}
