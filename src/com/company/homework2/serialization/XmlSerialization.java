package com.company.homework2.serialization;

import com.company.homework2.serialization.figure.Group;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.List;

public class XmlSerialization {
    public static String encode(List<Group> group) throws IllegalAccessException {
        String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
        xmlString += encodeGroup(group);
        return xmlString;
    }

    private static String encodeGroup(List<Group> group) throws IllegalAccessException {
        String xmlString = "";
        List<Group> groupList;
        for (Group shapes : group) {
            groupList = shapes.getGroups();
            xmlString += "<" + shapes.getClass().getSimpleName() + ">\n";
            for (Group shapesList : groupList) {
                Field[] fields = shapesList.getClass().getDeclaredFields();
                xmlString += "\t<" + shapesList.getClass().getSimpleName() + ">\n";

                for (Field field : fields) {
                    field.setAccessible(true);
                    if (field.getType().isArray()) {
                        for (int i = 0; i < Array.getLength(field.get(shapesList)); i++) {
                            xmlString += "\t\t<" + field.getName() + (i + 1) + ">";
                            xmlString += Array.get(field.get(shapesList), i).toString() + "</" + field.getName() + (i + 1) + ">\n";
                        }
                    } else {
                        xmlString += "\t\t<" + field.getName() + ">" + field.get(shapesList).toString() + "</" + field.getName() + ">\n";
                    }
                }
            }
            xmlString += "</" + shapes.getClass().getSimpleName() + ">\n";
        }
        return xmlString;
    }
}
