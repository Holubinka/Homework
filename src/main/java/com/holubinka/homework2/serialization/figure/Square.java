package com.holubinka.homework2.serialization.figure;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Square implements Shape {
    private double side;
    private double perimeter;
    private double area;

    public Square(double side) {
        this.side = side;
        setPerimeter();
        setArea();
    }

    private void setPerimeter() {
        perimeter = 4 * getSide();
    }

    @Override
    public void setArea() {
        area = new BigDecimal(Math.pow(getSide(), 2))
                .setScale(2, RoundingMode.UP)
                .doubleValue();
    }

    private double getSide() {
        return side;
    }

    @Override
    public String toString() {
        return "Square";
    }
}
