package com.company.homework2.serialization;

import com.company.homework2.serialization.figure.*;
import java.util.ArrayList;
import java.util.List;

public class Serialization {
    public static void main(String[] args) throws IllegalAccessException {
        List<Group> groups = new ArrayList<>();

        Group group = new Group();
        group.add(new Square(2));
        group.add(new Circle(5));
        group.add(new Triangle(new double[]{4, 5, 6}));
        group.add(new Square(5));
        groups.add(group);

        Group group1 = new Group();
        group1.add(new Square(10));
        group1.add(new Triangle(new double[]{10, 8, 3}));
        group1.add(new Square(50));
        group1.add(new Circle(50));
        group1.add(new Circle(1));
        group1.add(new Triangle(new double[]{15, 8, 8}));
        groups.add(group1);

        System.out.println(JsonSerialization.encode(groups));
        System.out.println(XmlSerialization.encode(groups));
    }
}
