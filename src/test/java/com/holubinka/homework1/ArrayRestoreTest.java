package com.holubinka.homework1;

import org.junit.Assert;
import org.junit.Test;

public class ArrayRestoreTest {
    ArrayRestore arrayRestore = new ArrayRestore();

    @Test
    public void testArrayRestoreForOneNegativeElement() {
        int[] expectedResult = new int[]{1, 2, 3, 4, 5, 6};
        int[] actualResult = arrayRestore.restore(new int[]{1, 2, -5, 4, 5, 6});
        Assert.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testArrayRestoreForTwoNegativeElement() {
        int[] expectedResult = new int[]{1, 2, 3, 4, 5, 6};
        int[] actualResult = arrayRestore.restore(new int[]{1, 2, -5, 4, -1, 6});
        Assert.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testArrayRestoreForTwoNegativeElementBeside() {
        int[] expectedResult = new int[]{1, 2, -5, -1, 4, 6};
        int[] actualResult = arrayRestore.restore(new int[]{1, 2, -5, -1, 4, 6});
        Assert.assertArrayEquals(expectedResult, actualResult);
    }
}
