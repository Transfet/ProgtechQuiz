import hu.transfet.unideb.application.service.PlayerServiceImpl;
import hu.transfet.unideb.application.model.player.Player;
import hu.transfet.unideb.application.model.player.PlayerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PlayerServiceTest {


    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerServiceImpl playerService;


    @Test
    public void testFindPlayersShouldSucceedWhenPlayersListNotNull() {

        Player testPlayer = new Player();
        testPlayer.setUserName("Test");

        List<Player> players = new ArrayList<>();
        players.add(testPlayer);

        when(playerRepository.findAll()).thenReturn(players);
        List<Player> checkPlayers = playerService.findAllPlayer();

        verify(playerRepository, times(1)).findAll();

        Assert.assertTrue(checkPlayers.size() > 0);
        Assert.assertEquals(testPlayer,players.get(0));
    }

    @Test
    public void testFindByIdTestShouldSucceedWhenPlayersHaveAnId() {

        Player testPlayer = new Player();
        testPlayer.setUserName("Test");
        testPlayer.setId(3L);

        when(playerRepository.findPlayerById(any(Long.class))).thenReturn(testPlayer);

        Player checkPlayer = playerService.findById(3L);

        verify(playerRepository,times(1)).findPlayerById(any(Long.class));

        Assert.assertEquals(checkPlayer,testPlayer);

    }

    @Test(expected = Exception.class)
    public void updateTest(){

        Double point = 100.0;
        Double time = 3.0;
        String userName = "Test";

        doThrow(Exception.class).when(playerRepository).updatePlayerPointAndTime(any(String.class),any(Double.class),any(Double.class));

        playerService.updatePlayerPointAndTime(userName,point,time);

        verify(playerRepository,times(1)).updatePlayerPointAndTime(any(String.class),any(Double.class),any(Double.class));

    }

    @Test(expected = Exception.class)
    public void testAddPlayer(){

        Player testPlayer = new Player();
        testPlayer.setUserName("Test");

        doThrow(Exception.class).when(playerRepository).save(any(Player.class));

        playerService.addPlayer(testPlayer);

        verify(playerRepository,times(1)).save(any(Player.class));
    }

    @Test(expected = NullPointerException.class)
    public void deletePlayerTest(){

        Player testPlayer = new Player();
        testPlayer.setUserName("Test");
        doThrow(NullPointerException.class).when(playerRepository).delete(any(Player.class));

        playerService.deletePlayer(testPlayer);

        verify(playerRepository,times(2)).delete(any(Player.class));

    }
}
