import application.database.PlayerService;
import application.model.player.Player;
import application.model.player.PlayerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by Transfet on 2017. 05. 18..
 */

@RunWith(MockitoJUnitRunner.class)
public class PlayerServiceTest {

    // Logger logger = LoggerFactory.getLogger(PlayerServiceTest.class);

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    private Player player;
    private Player savedPlayer;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        player = new Player("TestUserName", "TestFirstName", "TestLastName", "TestPw");
        savedPlayer = new Player();
    }

    @Test
    public void testFindPlayers() {

        List<Player> players = new ArrayList<>();
        players.add(player);

        when(playerRepository.findAll()).thenReturn(players);
        List<Player> checkPlayers = playerService.findAllPlayer();

        verify(playerRepository, times(1)).findAll();

        Assert.assertTrue(checkPlayers.size() > 0);
        Assert.assertEquals(player, checkPlayers.get(0));

    }

    /*@Test
    public void testAddPlayer() {

        doAnswer(invocationOnMock -> {
            Object[] args = invocationOnMock.getArguments();
            Object mock = invocationOnMock.getMock();
            System.out.println("method:" + Arrays.toString(args));
            return null;
        }).when(playerRepository).save(any(Player.class));

        playerService.addPlayer(any(Player.class));

        Assert.assertNull(playerService.findAllPlayer());

    }*/

}
