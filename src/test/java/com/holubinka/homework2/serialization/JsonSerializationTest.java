package com.holubinka.homework2.serialization;

import com.holubinka.homework2.serialization.figure.Circle;
import com.holubinka.homework2.serialization.figure.Group;
import com.holubinka.homework2.serialization.figure.Square;
import com.holubinka.homework2.serialization.figure.Triangle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class JsonSerializationTest {
    Group shapeGroup1;
    Group shapeGroup2;
    Group group;

    @Before
    public void setUp() {
        shapeGroup1 = new Group();
        shapeGroup2 = new Group();
        group = new Group();

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
    }

    @Test
    public void testJsonSerialization() throws IllegalAccessException {
        String expectedResult = "{\n" +
                "\t\"Group\" : {\n" +
                "\t\t\"Square\" : {\n" +
                "\t\t\t\"side\" : \"2.0\"\n" +
                "\t\t\t\"perimeter\" : \"8.0\"\n" +
                "\t\t\t\"area\" : \"4.0\"\n" +
                "\t\t}\n" +
                "\t\t\"Circle\" : {\n" +
                "\t\t\t\"radius\" : \"5.0\"\n" +
                "\t\t\t\"area\" : \"78.54\"\n" +
                "\t\t}\n" +
                "\t\t\"Triangle\" : {\n" +
                "\t\t\t\"sides\" : \"[4.0, 5.0, 6.0]\"\n" +
                "\t\t\t\"perimeter\" : \"15.0\"\n" +
                "\t\t\t\"area\" : \"9.93\"\n" +
                "\t\t}\n" +
                "\t\t\"Square\" : {\n" +
                "\t\t\t\"side\" : \"5.0\"\n" +
                "\t\t\t\"perimeter\" : \"20.0\"\n" +
                "\t\t\t\"area\" : \"25.0\"\n" +
                "\t\t}\n" +
                "\t}\n" +
                "\t\"Group\" : {\n" +
                "\t\t\"Square\" : {\n" +
                "\t\t\t\"side\" : \"10.0\"\n" +
                "\t\t\t\"perimeter\" : \"40.0\"\n" +
                "\t\t\t\"area\" : \"100.0\"\n" +
                "\t\t}\n" +
                "\t\t\"Triangle\" : {\n" +
                "\t\t\t\"sides\" : \"[10.0, 8.0, 3.0]\"\n" +
                "\t\t\t\"perimeter\" : \"21.0\"\n" +
                "\t\t\t\"area\" : \"9.93\"\n" +
                "\t\t}\n" +
                "\t\t\"Square\" : {\n" +
                "\t\t\t\"side\" : \"50.0\"\n" +
                "\t\t\t\"perimeter\" : \"200.0\"\n" +
                "\t\t\t\"area\" : \"2500.0\"\n" +
                "\t\t}\n" +
                "\t\t\"Circle\" : {\n" +
                "\t\t\t\"radius\" : \"50.0\"\n" +
                "\t\t\t\"area\" : \"7853.99\"\n" +
                "\t\t}\n" +
                "\t\t\"Circle\" : {\n" +
                "\t\t\t\"radius\" : \"1.0\"\n" +
                "\t\t\t\"area\" : \"3.15\"\n" +
                "\t\t}\n" +
                "\t\t\"Triangle\" : {\n" +
                "\t\t\t\"sides\" : \"[15.0, 8.0, 8.0]\"\n" +
                "\t\t\t\"perimeter\" : \"31.0\"\n" +
                "\t\t\t\"area\" : \"20.88\"\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";
        String actualResult = JsonSerialization.encode(group);
        Assert.assertEquals(expectedResult, actualResult);
    }
}
