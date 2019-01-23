package com.company.homework1;

import java.util.*;

public class ArrayRange {
    public static void main(String[] args) {
        range(enterArr());
    }

    private static int[]  enterArr() {
        Scanner in = new Scanner(System.in);

        System.out.print("Введіть розмірність масива: ");
        int count = in.nextInt();
        int [] arr = new int[count];

        System.out.print("Введіть масив: ");
        for (int i = 0; i < count; i++) {
            arr[i] = in.nextInt();
        }
        return arr;
    }

    private static void range (int [] arr) {
        int [] temp = Arrays.copyOf(arr, arr.length + 1);
        int count = 0;

        System.out.print("Результат: ");

        for (int i = 0; i < temp.length - 1; i++) {
            if (temp[i + 1] - temp[i] == 1) {
                if(count < 1) {
                    System.out.print("[ " + temp[i] + " ");
                }
                count++;
            } else if(temp[i] - temp[i - 1] == 1) {
                System.out.print(temp[i] + " ] ");
                count = 0;
            } else {
                System.out.print("[ " + temp[i] + " ] ");
                count = 0;
            }
        }
    }
}
