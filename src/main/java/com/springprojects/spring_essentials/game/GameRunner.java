package com.springprojects.spring_essentials.game;

public class GameRunner {

    private GamingConsole gamingConsole;

    public GameRunner(GamingConsole gamingConsole) {
        this.gamingConsole = gamingConsole;
    }

    public void run() {
        System.out.println("Running Game: " + gamingConsole);
        gamingConsole.right();
        gamingConsole.left();
        gamingConsole.up();
        gamingConsole.down();
    }
}
