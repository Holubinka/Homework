package com.company.homework4;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        System.out.println("Size = " + list.size());
        list.add(5);
        list.add(10);
        list.add(15);
        list.add(17);
        list.add(0);
        list.add(3);
        System.out.println("ArrayList = " + list);
        System.out.println("Get second element = " + list.get(1));
        list.remove(0);
        System.out.println("After removing the first element");
        System.out.println("ArrayList = " + list);
        System.out.println("Size = " + list.size());

        System.out.println("---------------------------------------");

        List<Integer> linkedList = new LinkedList<>();

        linkedList.add(10);
        linkedList.add(12);
        linkedList.add(13);
        linkedList.add(14);
        linkedList.add(15);
        linkedList.add(16);
        linkedList.add(17);
        System.out.println("LinkedList= " + linkedList);
        System.out.println("Size= " + linkedList.size());
        System.out.println("Get fifth element = " + linkedList.get(4));
        linkedList.remove(2);
        System.out.println("After removing the third element");
        System.out.println("LinkedList = " + linkedList);
        System.out.println("Size = " + linkedList.size());
    }
}
