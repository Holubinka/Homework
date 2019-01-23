package com.company.homework2.builder;

public class Person{
    private final String name;
    private final int age;
    private final String adress;
    private final double height;
    private final String colorEye;

    public Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.adress = builder.adress;
        this.height = builder.height;
        this.colorEye = builder.colorEye;
    }

    public static class Builder {
        private String name;
        private int age;
        private String adress;
        private double height;
        private String colorEye;

        public Builder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Builder setAdress(String adress) {
            this.adress = adress;
            return  this;
        }

        public Builder setHeight(double height) {
            this.height = height;
            return this;
        }

        public Builder setColorEye(String colorEye) {
            this.colorEye = colorEye;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", age=" + age +
                ", adress='" + adress + '\'' +
                ", height=" + height +
                ", colorEye='" + colorEye + '\'';
    }
}
