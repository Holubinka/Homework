package com.company.homework2.serialization;

import com.company.homework2.serialization.figure.Group;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.List;

public class JsonSerialization {
    public static String encode(List<Group> group) throws IllegalAccessException {
        String jsonString = "{\n";
        jsonString += encodeGroup(group);
        jsonString += "}";
        return jsonString;
    }

    private static String encodeGroup(List<Group> group) throws IllegalAccessException {
        String jsonString = "";
        List<Group> groupList;
        for (Group shapes : group) {
            groupList = shapes.getGroups();
            jsonString += "\t\"" + shapes.getClass().getSimpleName() + "\" : {\n";

            for (Group shapesList : groupList) {
                Field[] fields = shapesList.getClass().getDeclaredFields();
                jsonString += "\t\t\"" + shapesList.getClass().getSimpleName() + "\" : {\n";

                for (Field field : fields) {
                    field.setAccessible(true);

                    if (field.getType().isArray()) {
                        jsonString += "\t\t\t\"" + field.getName() + "\" : ";
                        jsonString += "\"" + displayArray(field.get(shapesList)) + "\"\n";
                    } else {
                        jsonString += "\t\t\t\"" + field.getName() + "\" : \"" + field.get(shapesList).toString() + "\"\n";
                    }
                }
                jsonString += "\t\t}\n";
            }
            jsonString += "\t}\n";
        }
        return jsonString;
    }

    private static String displayArray(Object theArray) {
        String jsonString = "";
        int length = Array.getLength(theArray);

        jsonString += "[";
        for (int j = 0; j < length; j++) {
            jsonString += Array.get(theArray, j).toString();
            if (j != length - 1) {
                jsonString += ", ";
            }
        }
        jsonString += "]";
        return jsonString;
    }
}
