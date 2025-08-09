package com.springprojects.spring_essentials.updatedgame;

import com.springprojects.spring_essentials.game.GameRunner;
import com.springprojects.spring_essentials.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.springprojects.spring_essentials.game")
public class GamingConfigurationSpringBeans {

//    @Bean
//    public GamingConsole game() {
//        var game = new PacmanGame();
//        return game;
//    }

//    @Bean
//    public GameRunner gameRunner(GamingConsole game) {
//        System.out.println("test");
//        var gameRunner = new GameRunner(game);
//        return gameRunner;
//    }

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(GamingConfigurationSpringBeans.class)) {
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}
