package com.company.homework2.immutable;


public class Parents implements Cloneable {
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

    public Parents clone() {
        try {
            return (Parents) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}