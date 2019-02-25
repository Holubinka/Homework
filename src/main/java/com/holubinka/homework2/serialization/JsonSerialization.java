package com.holubinka.homework2.serialization;

import com.holubinka.homework2.serialization.figure.Group;
import com.holubinka.homework2.serialization.figure.Shape;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.List;

public class JsonSerialization {
    public static String encode(Group group) throws IllegalAccessException {
        String jsonString = "{\n";
        jsonString += encodeGroup(group);
        jsonString += "}";
        return jsonString;
    }

    private static String encodeGroup(Group group) throws IllegalAccessException {
        String jsonString = "";
        List<Group> groups = group.getGroups();

        for (Group group1 : groups) {
            jsonString += "\t\"" + group1.getClass().getSimpleName().toLowerCase() + "\" : [\n";
            jsonString += encodeShape(group1);
            jsonString += "\t]\n";
        }
        return jsonString;
    }

    private static String encodeShape(Group group) throws IllegalAccessException {
        String jsonString = "";
        int i = 0;
        List<Shape> shapes = group.getShapes();

        for (Shape shape : shapes) {
            Field[] fields = shape.getClass().getDeclaredFields();
            jsonString += "\t\t" + "{\n";
            jsonString += encodeField(fields, shape);
            jsonString += "\t\t}";

            if (i != shapes.size() - 1) {
                jsonString += ",\n";
                i++;
            } else {
                jsonString += "\n";
            }
        }

        return jsonString;
    }

    private static String encodeField(Field[] fields, Shape shape) throws IllegalAccessException {
        String jsonString = "";

        for (Field field : fields) {
            field.setAccessible(true);

            if (field.getType().isArray()) {
                jsonString += encodeArrayField(field, shape);
            } else {
                jsonString += "\t\t\t\"" + field.getName() + "\" : ";
                jsonString += "\"" + field.get(shape).toString() + "\"\n";
            }
        }
        return jsonString;
    }

    private static String encodeArrayField(Field field, Shape shape) throws IllegalAccessException {
        String jsonString = "";

        jsonString += "\t\t\t\"" + field.getName() + "\" : ";
        jsonString += "\"" + displayArray(field.get(shape)) + "\"\n";

        return jsonString;
    }

    private static String displayArray(Object theArray) {
        String jsonString = "";
        int length = Array.getLength(theArray);

        jsonString += "[";

        for (int j = 0; j < length; j++) {
            jsonString += "{" + Array.get(theArray, j).toString() + "}";
            if (j != length - 1) {
                jsonString += ", ";
            }
        }
        jsonString += "]";
        return jsonString;
    }
}
