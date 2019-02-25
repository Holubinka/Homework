package com.company.homework2.immutable;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ImmutablePerson immutablePerson = new ImmutablePerson("Vitalik", 22, "Lviv", new Parents("father", "mother"));

        System.out.println("Person перед зміною");
        System.out.println(immutablePerson);

        immutablePerson.getParent().setFather("father1");
        immutablePerson.getParent().setMother("mother1");

        System.out.println("Person після зміни");
        System.out.println(immutablePerson);
    }
}
