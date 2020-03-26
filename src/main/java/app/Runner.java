package app;


import entities.*;
import services.*;

import java.util.*;

public class Runner {
        public static void main(String[] args) {
            PlayerService ps = new PlayerService();
            GameService gs = new GameService();
            Player test = new Player();
            Game testGame = new Game();
            List<Game> games = new ArrayList<>();
            test.setUserName("Fred");
            test.setMoney(100);
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
            System.out.println("Got here");
        }
}
