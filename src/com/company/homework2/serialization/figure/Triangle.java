package com.company.homework2.serialization.figure;

public class Triangle implements Shape {
    private double[] sides;
    private double perimeter;
    private double area;

    public Triangle(double[] sides) {
        this.sides = sides;
        setPerimeter();
        setArea();
    }

    private boolean existTriangle() {
        if ((sides[0] + sides[1] > sides[2])
                && (sides[0] + sides[2] > sides[1])
                && (sides[1] + sides[2] > sides[0])) {
            return true;
        } else {
            return false;
        }
    }

    private void setPerimeter() {
        if (existTriangle()) {
            for (int i = 0; i < sides.length; i++) {
                perimeter += sides[i];
            }
        } else {
            throw new IllegalArgumentException("Такого трикутника не існує");
        }
    }

    @Override
    public void setArea() {
        if (existTriangle()) {
            double p = perimeter / 2;
            area = Math.sqrt(p * (p - sides[0]) * (p - sides[1]) * (p - sides[2]));
        }
    }

    @Override
    public String toString() {
        return "Triangle";
    }
}
