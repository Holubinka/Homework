package com.holubinka.homework2.builder;

public class Person {
    private final String name;
    private final int age;
    private final String address;
    private final double height;
    private final String colorEye;

    private Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.age = personBuilder.age;
        this.address = personBuilder.address;
        this.height = personBuilder.height;
        this.colorEye = personBuilder.colorEye;
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

    public double getHeight() {
        return height;
    }

    public String getColorEye() {
        return colorEye;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", height=" + height +
                ", colorEye='" + colorEye + '\'';
    }

    public static class PersonBuilder {
        private String name;
        private int age;
        private String address;
        private double height;
        private String colorEye;

        public PersonBuilder(String name, int age) {
            this.name = name;
            this.age = age;
        }


        public PersonBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public PersonBuilder setHeight(double height) {
            this.height = height;
            return this;
        }

        public PersonBuilder setColorEye(String colorEye) {
            this.colorEye = colorEye;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
