package com.holubinka.homework1;

import java.util.Arrays;

public class ArrayRange {
    public String range(int[] arr) {
        int[] temp = Arrays.copyOf(arr, arr.length + 1);
        int count = 0;
        StringBuilder rangeBuilder = new StringBuilder();

        System.out.print("Результат: ");
        for (int i = 0; i < temp.length - 1; i++) {
            if (temp[i + 1] - temp[i] == 1) {
                if (count < 1) {
                    rangeBuilder.append("[").append(temp[i]).append(" ");
                }
                count++;
            } else if ((i != 0) && (temp[i] - temp[i - 1] == 1)) {
                rangeBuilder.append(temp[i]).append("]");
                count = 0;
            } else {
                rangeBuilder.append("[").append(temp[i]).append("]");
                count = 0;
            }
        }
        return rangeBuilder.toString();
    }
}
