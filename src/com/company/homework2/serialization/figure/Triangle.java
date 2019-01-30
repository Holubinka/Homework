package com.company.homework2.serialization.figure;

public class Triangle extends Group {
    private double[] side;
    private double perimeter;

    public Triangle(double[] side) {
        this.side = side;
        setPerimeter();
    }

    private boolean existTriangle() {
        if ((side[0] + side[1] > side[2])
                && (side[0] + side[2] > side[1])
                && (side[1] + side[2] > side[0])) {
            return true;
        } else {
            return false;
        }
    }

    private void setPerimeter() {
        if (existTriangle()) {
            for (int i = 0; i < side.length; i++) {
                perimeter += side[i];
            }
        } else {
            System.out.println("Такого трикутника не існує");
        }
    }

    @Override
    public String toString() {
        return "Triangle";
    }
}


