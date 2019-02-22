package com.holubinka.homework1;

import java.util.Arrays;

public class ArrayRotation {
    public static int[] rotated(int[] arr, int position) {
        int[] temp = Arrays.copyOf(arr, arr.length);

        for (int i = 0; i < temp.length; i++) {
            if (i < position) {
                temp[arr.length - position + i] = arr[i];
            } else {
                temp[i - position] = arr[i];
            }
        }
        return temp;
    }
}
