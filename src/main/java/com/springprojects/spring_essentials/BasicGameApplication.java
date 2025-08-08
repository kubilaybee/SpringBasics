package com.springprojects.spring_essentials;

import com.springprojects.spring_essentials.game.GameRunner;
import com.springprojects.spring_essentials.game.PacmanGame;

public class BasicGameApplication {
    public static void main(String[] args) {
        //var game = new MarioGame();
        //var game = new SuperContraGame();

        var game = new PacmanGame(); //1: Object Creation

        var gameRunner = new GameRunner(game);
        //2: Object Creation + Wiring of Dependencies
        // Game is a Dependency of GameRunner

        gameRunner.run();
    }
}
