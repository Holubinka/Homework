package com.company.homework2.immutable;

public final class ImmutablePerson {
    private final String name;
    private final int age;
    private final String address;
    private final Parents parent;

    public ImmutablePerson(String name, int age, String address, Parents parent) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.parent = new Parents(parent.getFather(), parent.getMother());
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public Parents getParent() {
        return parent.clone();
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", parent: " + parent;
    }
}

