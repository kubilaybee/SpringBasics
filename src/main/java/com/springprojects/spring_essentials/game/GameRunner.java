package com.springprojects.spring_essentials.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    private GamingConsole gamingConsole;

    public GameRunner(@Qualifier("SuperContraGameQualifier") GamingConsole gamingConsole) {
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
