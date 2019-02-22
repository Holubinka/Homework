package com.holubinka.homework3.mergesort;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SortingTest {
    Sorting sorting = new Sorting();

    @Test
    public void testMergeSortForFiveElement() {
        int[] expectedResult = new int[]{2, 3, 4, 6, 8, 10, 1, 5};
        int[] actualResult = new int[]{6, 8, 2, 4, 3, 10, 1, 5};
        sorting.mergeSort(actualResult, 0, 4);
        Assert.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testMergeSortForThreeElement() {
        int[] expectedResult = new int[]{2, 6, 8, 4, 3, 10, 1, 5};
        int[] actualResult = new int[]{6, 8, 2, 4, 3, 10, 1, 5};
        sorting.mergeSort(actualResult, 0, 2);
        Assert.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testMergeSortForAllElement() {
        int[] expectedResult = new int[]{1, 2, 3, 4, 5, 6, 8, 10};
        int[] actualResult = new int[]{6, 8, 2, 4, 3, 10, 1, 5};
        sorting.mergeSort(actualResult, 0, actualResult.length - 1);
        Assert.assertArrayEquals(expectedResult, actualResult);
    }
}