package com.holubinka.homework1;

import java.util.Arrays;

public class ArrayRestore {
    public int[] restore(int[] arr) {
        int[] temp = Arrays.copyOf(arr, arr.length);

        for (int i = 1; i < temp.length - 1; i++) {
            if ((Math.abs(temp[i + 1] - temp[i - 1]) == 2) && (temp[i] < 0)) {
                temp[i] = (temp[i + 1] + temp[i - 1]) / 2;
            }
        }
        return temp;
    }
}
