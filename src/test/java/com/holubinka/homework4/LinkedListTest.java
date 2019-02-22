package com.holubinka.homework4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
    List<Integer> linkedList;

    @Before
    public void setUp() {
        linkedList = new LinkedList<>();
        linkedList.add(45);
        linkedList.add(5);
        linkedList.add(-24);
    }

    @Test
    public void testNotEmptyLinkedListForSize() {
        Assert.assertEquals(3, linkedList.size());
    }

    @Test
    public void testNotEmptyLinkedListForGetFirstElement() {
        int expectedResult = 45;
        int actualResult = linkedList.get(0);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testNotEmptyLinkedListForAddTwoElement() {
        Assert.assertEquals(3, linkedList.size());
        linkedList.add(1);
        linkedList.add(2);
        Assert.assertEquals(5, linkedList.size());
    }

    @Test
    public void testNotEmptyLinkedListForRemoveOneElement() {
        Assert.assertEquals(3, linkedList.size());
        linkedList.remove(1);
        Assert.assertEquals(2, linkedList.size());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testNotEmptyLinkedListGetFifthElement() {
        linkedList.get(5);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testNotEmptyLinkedListRemoveFifthElement() {
        linkedList.remove(5);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testNotEmptyLinkedListRemoveNegativeIndexElement() {
        linkedList.remove(-1);
    }

}