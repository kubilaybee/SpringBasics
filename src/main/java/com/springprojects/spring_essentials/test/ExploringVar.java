package com.springprojects.spring_essentials.test;

import java.util.ArrayList;

public class ExploringVar {
    public static void main(String[] args) {
        var myList = new ArrayList<String>();

        myList.add("String");
        for (var element : myList) {
            System.out.println(element);
        }
        System.out.println(myList.getClass());
    }
}
