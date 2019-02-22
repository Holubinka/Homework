package com.holubinka.homework4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ArrayListTest {
    List<Integer> list;

    @Before
    public void setUp() {
        list = new ArrayList<>();
        list.add(10);
        list.add(35);
        list.add(-1);
    }

    @Test
    public void testNotEmptyArrayListForSize() {
        Assert.assertEquals(3, list.size());
    }

    @Test
    public void testNotEmptyArrayListForGetFirstElement() {
        int expectedResult = 10;
        int actualResult = list.get(0);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testNotEmptyArrayListForAddTwoElement() {
        Assert.assertEquals(3, list.size());
        list.add(1);
        list.add(2);
        Assert.assertEquals(5, list.size());
    }

    @Test
    public void testNotEmptyArrayListForRemoveOneElement() {
        Assert.assertEquals(3, list.size());
        list.remove(1);
        Assert.assertEquals(2, list.size());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testNotEmptyArrayListGetFifthElement() {
        list.get(5);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testNotEmptyArrayListRemoveFifthElement() {
        list.remove(5);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testNotEmptyArrayListRemoveNegativeIndexElement() {
        list.remove(-1);
    }
}