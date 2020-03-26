package services;

import entities.*;
import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

public class GameServiceTest {

    private static PlayerService ps;
    private static GameService gs;


    @Before
    public void setUp() {
        ps = new PlayerService();
        gs = new GameService();
    }

    @Test
    public void findById() {
        Game testGame = gs.findById(1L);
        Assert.assertNotNull(testGame);
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
        List<Game> players = gs.findAll();
        Assert.assertTrue(players.size() > 0);
    }

    @Test
    public void update() {
        Game testGame = gs.findById(1L);
        testGame.setName("Halo 3");
        gs.update(testGame);
        Game reload = gs.findById(1L);
        String expected = "Halo 3";
        String actual = reload.getName();
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

        List<Game> players = gs.findAll();
        boolean found = false;
        for (Game p : players) {
            if (p.equals(testGame)) {
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

        List<Game> players = gs.findAll();
        boolean found = false;
        for (Game p : players) {
            if (p.equals(testGame)) {
                found = true;
                break;
            }
        }

        Assert.assertFalse(found);

    }
}