package com.springprojects.spring_essentials.examples.h1;

import com.springprojects.spring_essentials.game.GameRunner;
import java.util.Arrays;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class XmlConfigurationContextLauncherApp {

    public static void main(String[] args) {
        try (var context =
                     new ClassPathXmlApplicationContext("contextConfiguration.xml")) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("number"));
            context.getBean(GameRunner.class).run();
        }
    }
}
