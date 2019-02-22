package com.holubinka.homework2.serialization;

import com.holubinka.homework2.serialization.figure.Circle;
import com.holubinka.homework2.serialization.figure.Group;
import com.holubinka.homework2.serialization.figure.Square;
import com.holubinka.homework2.serialization.figure.Triangle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class XmlSerializationTest {
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
    public void testXmlSerialization() throws IllegalAccessException {
        String expectedResult = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<Group>\n" +
                "\t<Square>\n" +
                "\t\t<side>2.0</side>\n" +
                "\t\t<perimeter>8.0</perimeter>\n" +
                "\t\t<area>4.0</area>\n" +
                "\t</Square\n" +
                "\t<Circle>\n" +
                "\t\t<radius>5.0</radius>\n" +
                "\t\t<area>78.54</area>\n" +
                "\t</Circle\n" +
                "\t<Triangle>\n" +
                "\t\t<sides1>4.0</sides1>\n" +
                "\t\t<sides2>5.0</sides2>\n" +
                "\t\t<sides3>6.0</sides3>\n" +
                "\t\t<perimeter>15.0</perimeter>\n" +
                "\t\t<area>9.93</area>\n" +
                "\t</Triangle\n" +
                "\t<Square>\n" +
                "\t\t<side>5.0</side>\n" +
                "\t\t<perimeter>20.0</perimeter>\n" +
                "\t\t<area>25.0</area>\n" +
                "\t</Square\n" +
                "</Group>\n" +
                "<Group>\n" +
                "\t<Square>\n" +
                "\t\t<side>10.0</side>\n" +
                "\t\t<perimeter>40.0</perimeter>\n" +
                "\t\t<area>100.0</area>\n" +
                "\t</Square\n" +
                "\t<Triangle>\n" +
                "\t\t<sides1>10.0</sides1>\n" +
                "\t\t<sides2>8.0</sides2>\n" +
                "\t\t<sides3>3.0</sides3>\n" +
                "\t\t<perimeter>21.0</perimeter>\n" +
                "\t\t<area>9.93</area>\n" +
                "\t</Triangle\n" +
                "\t<Square>\n" +
                "\t\t<side>50.0</side>\n" +
                "\t\t<perimeter>200.0</perimeter>\n" +
                "\t\t<area>2500.0</area>\n" +
                "\t</Square\n" +
                "\t<Circle>\n" +
                "\t\t<radius>50.0</radius>\n" +
                "\t\t<area>7853.99</area>\n" +
                "\t</Circle\n" +
                "\t<Circle>\n" +
                "\t\t<radius>1.0</radius>\n" +
                "\t\t<area>3.15</area>\n" +
                "\t</Circle\n" +
                "\t<Triangle>\n" +
                "\t\t<sides1>15.0</sides1>\n" +
                "\t\t<sides2>8.0</sides2>\n" +
                "\t\t<sides3>8.0</sides3>\n" +
                "\t\t<perimeter>31.0</perimeter>\n" +
                "\t\t<area>20.88</area>\n" +
                "\t</Triangle\n" +
                "</Group>\n";
        String actualResult = XmlSerialization.encode(group);
        Assert.assertEquals(expectedResult, actualResult);
    }
}
