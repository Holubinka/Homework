package com.holubinka.homework1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class ArrayRangeTest {
    ArrayRange arrayRange = new ArrayRange();

    @Test
    public void testArrayRangeForDifferentArguments() {
        String expectedResult = "[1 3][5 6][8][10 11]";
        String actualResult = arrayRange.range(new int[]{1, 2, 3, 5, 6, 8, 10, 11});
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testArrayRangeCorrectForOneAndLastSingleElement() {
        String expectedResult = "[1][5 6][8 9][11]";
        String actualResult = arrayRange.range(new int[]{1, 5, 6, 8, 9, 11});
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testArrayRangeCorrectForOnlyOneElement() {
        String expectedResult = "[1][5][8][11]";
        String actualResult = arrayRange.range(new int[]{1, 5, 8, 11});
        Assert.assertEquals(expectedResult, actualResult);
    }

}