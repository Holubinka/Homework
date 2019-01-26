package com.company.homework2.serialization.figure;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private List<Group> groups = new ArrayList<>();

    public void add(Group group) {
        groups.add(group);
    }

    public void remove(Group group) {
        groups.remove(group);
    }

    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public String toString() {
        return "Group";
    }
}
