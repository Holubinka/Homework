package com.holubinka.homework2.serialization.figure;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Circle implements Shape {
    private double radius;
    private double area;

    public Circle(double radius) {
        this.radius = radius;
        setArea();
    }

    @Override
    public void setArea() {
        area = new BigDecimal(Math.PI * Math.pow(this.radius, 2))
                .setScale(2, RoundingMode.UP)
                .doubleValue();
    }

    @Override
    public String toString() {
        return "Circle";
    }
}
