package com.company.Homework2.Immutable;

import java.util.Date;
final class ImmutablePerson {
    private final String name;
    private final int age;
    private final String colorEye;
    private final Date birthDay;

    public ImmutablePerson(String name, int age, String colorEye, Date birthDay) {
        this.name = name;
        this.age = age;
        this.colorEye = colorEye;
        this.birthDay = new Date(birthDay.getTime());
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColorEye() {
        return colorEye;
    }

    public Date getBirthDay() {
        return new Date(birthDay.getTime());
    }
}

public class  Main {
    public static void main(String[] args) {
        ImmutablePerson immutablePerson = new  ImmutablePerson("Vitalik",22, "Green", new Date());

        System.out.println(immutablePerson.getName());
        System.out.println(immutablePerson.getAge());
        System.out.println(immutablePerson.getColorEye());
        System.out.println(immutablePerson.getBirthDay());
    }
}
