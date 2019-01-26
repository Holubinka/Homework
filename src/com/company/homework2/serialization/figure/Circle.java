package com.company.homework2.serialization.figure;

public class Circle extends Group {
    private double radius;
    private double area;

    public Circle(double radius) {
        this.radius = radius;
        setArea();
    }

    private double getRadius() {
        return radius;
    }

    private void setArea() {
        area = Math.PI * Math.pow(getRadius(), 2);
    }

    @Override
    public String toString() {
        return "Circle";
    }
}
