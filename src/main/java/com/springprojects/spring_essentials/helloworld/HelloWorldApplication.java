package com.springprojects.spring_essentials.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldApplication {

    public static void main(String[] args) {
        //1: Launch a Spring Context
        try (var context =
                     new AnnotationConfigApplicationContext
                             (HelloWorldConfiguration.class)) {
            //2: Configure the things that we want Spring to manage -
            // HelloWorldConfiguration - @Configuration//name - @Bean
            //3: Retrieving Beans managed by Spring
            System.out.println(context.getBean("name"));
            // Joe
            System.out.println(context.getBean("age"));
            // 22
            System.out.println(context.getBean("person"));
            // Person[name=Jane, age=40, address=Address[firstLine=Street, city=City]]
            System.out.println(context.getBean("person2MethodCall"));
            // Person[name=Joe, age=22, address=Address[firstLine=Baker Street, city=London]]
            System.out.println(context.getBean("person3Parameters"));
            // Person[name=Joe, age=22, address=Address[firstLine=Baker Street, city=London]]
            System.out.println(context.getBean("address2"));
            // Address[firstLine=Baker Street, city=London]
            System.out.println(context.getBean(Person.class));
            // Person[name=Joe, age=22, address=Address[firstLine=Baker Street, city=London]]
            System.out.println(context.getBean(Address.class));
            // Address[firstLine=Baker Street, city=London]
            System.out.println(context.getBean("person5Qualifier"));
            // Person[name=Joe, age=22, address=Address[firstLine=Qualifier3, city=address3]]

        }
    }
}
