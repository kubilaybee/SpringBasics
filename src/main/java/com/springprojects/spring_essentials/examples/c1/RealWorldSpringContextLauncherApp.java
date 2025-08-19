package com.springprojects.spring_essentials.examples.c1;

import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.springprojects.spring_essentials.examples.c1")
public class RealWorldSpringContextLauncherApp {
    public static void main(String[] args) {

        try (var context =
                     new AnnotationConfigApplicationContext(
                             RealWorldSpringContextLauncherApp.class)) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            System.out.println(
                    context.getBean(BusinessCalculationService.class).findMax());

        }
    }
}
