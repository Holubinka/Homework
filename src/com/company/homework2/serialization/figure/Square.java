package com.company.homework2.serialization.figure;

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
        area = Math.pow(getSide(), 2);
    }

    private double getSide() {
        return side;
    }

    @Override
    public String toString() {
        return "Square";
    }
}
