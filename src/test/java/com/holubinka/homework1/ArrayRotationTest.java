package com.holubinka.homework1;

import org.junit.Assert;
import org.junit.Test;

public class ArrayRotationTest {
    @Test
    public void testArrayRotationForOneElement() {
        int[] expectedResult = new int[]{2, 3, 4, 5, 6, 7, 1};
        int[] actualResult = ArrayRotation.rotated(new int[]{1, 2, 3, 4, 5, 6, 7}, 1);
        Assert.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testArrayRotationForTwoElement() {
        int[] expectedResult = new int[]{3, 4, 5, 6, 7, 1, 2};
        int[] actualResult = ArrayRotation.rotated(new int[]{1, 2, 3, 4, 5, 6, 7}, 2);
        Assert.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testArrayRotationForAllElement() {
        int[] expectedResult = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] actualResult = ArrayRotation.rotated(new int[]{1, 2, 3, 4, 5, 6, 7}, 7);
        Assert.assertArrayEquals(expectedResult, actualResult);
    }
}
