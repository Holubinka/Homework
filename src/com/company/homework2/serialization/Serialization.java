package com.company.homework2.serialization;

import com.company.homework2.serialization.figure.*;

public class Serialization {
    public static void main(String[] args) throws IllegalAccessException {
        Group shapeGroup1 = new Group();
        Group shapeGroup2 = new Group();
        Group group = new Group();

        shapeGroup1.addShape(new Square(2));
        shapeGroup1.addShape(new Circle(5));
        shapeGroup1.addShape(new Triangle(new double[]{4, 5, 6}));
        shapeGroup1.addShape(new Square(5));
        group.addGroup(shapeGroup1);

        shapeGroup2.addShape(new Square(10));
        shapeGroup2.addShape(new Triangle(new double[]{10, 8, 3}));
        shapeGroup2.addShape(new Square(50));
        shapeGroup2.addShape(new Circle(50));
        shapeGroup2.addShape(new Circle(1));
        shapeGroup2.addShape(new Triangle(new double[]{15, 8, 8}));
        group.addGroup(shapeGroup2);

        System.out.println(JsonSerialization.encode(group));
        System.out.println(XmlSerialization.encode(group));
    }
}
