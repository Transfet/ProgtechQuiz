package hu.transfet.unideb.test.testservice;

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

    @Test
    public void testPlayerUpdateShouldSucceedWhenPlayersPropertiesAreNotNull(){

        Double point = 100.0;
        Double time = 3.0;
        String userName = "Test";

        playerService.updatePlayerPointAndTime(userName,point,time);

        verify(playerRepository,times(1)).updatePlayerPointAndTime(any(String.class),any(Double.class),any(Double.class));

    }

    @Test
    public void testAddPlayerShouldSucceedWhenPlayerIsNotNull(){

        Player testPlayer = new Player();
        testPlayer.setUserName("Test");

        when(playerRepository.save(any(Player.class))).thenReturn(any(Player.class));

        playerService.addPlayer(testPlayer);
        verify(playerRepository,times(1)).save(any(Player.class));

    }

    @Test
    public void testDeletePlayerShouldSucceedWhenPlayerIsExists(){

        Player testPlayer = new Player();
        testPlayer.setUserName("Test");


        playerService.deletePlayer(testPlayer);
        verify(playerRepository,times(1)).delete(any(Player.class));

    }
}
