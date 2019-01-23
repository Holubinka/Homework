package com.company.homework2.builder;

public class Main {
    public static void main(String[] args) {
        Person person = new Person.Builder("Vitalik", 22)
                .setAdress("Lviv")
                .setHeight(183.5)
                .setColorEye("Green")
                .build();

        System.out.println(person);
    }
}
