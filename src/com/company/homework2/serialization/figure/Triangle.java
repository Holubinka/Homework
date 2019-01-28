package com.company.homework2.serialization.figure;

public class Triangle implements Shape {
    private double[] side;
    private double perimeter;
    private double area;

    public Triangle(double[] side) {
        this.side = side;
        setPerimeter();
        setArea();
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
    public void setArea() {
        if (existTriangle()) {
            double p = perimeter / 2;
            area = Math.sqrt(p * (p - side[0]) * (p - side[1]) * (p - side[2]));
        }
    }

    @Override
    public String toString() {
        return "Triangle";
    }
}


