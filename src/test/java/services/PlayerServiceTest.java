package services;

import entities.*;
import org.junit.*;

import java.util.*;

public class PlayerServiceTest {
    private static PlayerService ps;
    private static GameService gs;


    @Before
    public void setUp() {
        ps = new PlayerService();
        gs = new GameService();
    }

    @Test
    public void findById() {
        Player testPlayer = ps.findById(1L);
        Assert.assertNotNull(testPlayer);
    }

    @Test
    public void findAll() {
        Player test = new Player();
        Game testGame = new Game();
        List<Game> games = new ArrayList<>();
        test.setUserName("Pete");
        test.setMoney(100);
        test.setAge(53);
        test.setPassword("root");
        testGame.setName("Fortnite");
        testGame.setPlatform("PC");
        testGame.setGenre("Battle Royale");
        testGame.setRetailPrice(0);
        testGame.setAgeMin(10);
        testGame.setOwner(test);
        games.add(testGame);
        test.setPlatforms(new ArrayList<>());
        test.setGamesOwned(games);
        gs.create(testGame);
        ps.create(test);
        List<Player> players = ps.findAll();
        Assert.assertTrue(players.size() > 0);
    }

    @Test
    public void update() {
        Player testGame = ps.findById(1L);
        testGame.setUserName("JohhnyBoy");
        ps.update(testGame);
        Player reload = ps.findById(1L);
        String expected = "JohhnyBoy";
        String actual = reload.getUserName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void create() {
        Player test = new Player();
        Game testGame = new Game();
        List<Game> games = new ArrayList<>();
        test.setUserName("John");
        test.setMoney(100);
        test.setAge(22);
        test.setPassword("root");
        testGame.setName("Fortnite");
        testGame.setPlatform("PC");
        testGame.setGenre("Battle Royale");
        testGame.setRetailPrice(0);
        testGame.setAgeMin(10);
        testGame.setOwner(test);
        games.add(testGame);
        test.setPlatforms(new ArrayList<>());
        test.setGamesOwned(games);
        gs.create(testGame);
        ps.create(test);

        List<Player> players = ps.findAll();
        boolean found = false;
        for (Player p : players) {
            if (p.equals(test)) {
                found = true;
                break;
            }
        }

        Assert.assertTrue(found);
    }

    @Test
    public void delete() {
        Player test = new Player();
        Game testGame = new Game();
        List<Game> games = new ArrayList<>();
        test.setUserName("Pete");
        test.setMoney(100);
        test.setAge(53);
        test.setPassword("root");
        testGame.setName("Fortnite");
        testGame.setPlatform("PC");
        testGame.setGenre("Battle Royale");
        testGame.setRetailPrice(0);
        testGame.setAgeMin(10);
        testGame.setOwner(test);
        games.add(testGame);
        test.setPlatforms(new ArrayList<>());
        test.setGamesOwned(games);
        gs.create(testGame);
        ps.create(test);

        gs.delete(testGame);

        List<Player> players = ps.findAll();
        boolean found = false;
        for (Player p : players) {
            if (p.equals(test)) {
                found = true;
                break;
            }
        }

        Assert.assertFalse(found);

    }
}