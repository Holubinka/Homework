package com.company.homework2.immutable;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ImmutablePerson immutablePerson = new ImmutablePerson("Vitalik",22, "Green", new Date());

        System.out.println(immutablePerson);
    }
}
