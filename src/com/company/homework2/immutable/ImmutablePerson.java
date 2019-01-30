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
        return new Parents(this.parent.getFather(), this.parent.getMother());
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", parent: " + parent;
    }
}

class Parents {
    private String father;
    private String mother;

    public Parents(String father, String mother) {
        this.father = father;
        this.mother = mother;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    @Override
    public String toString() {
        return "father='" + father + '\'' +
                ", mother='" + mother + '\'';
    }
}
