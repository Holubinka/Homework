package com.company.homework1;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork1_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введіть розмірність масива: ");
        int count = in.nextInt();
        int[] arr = new int[count];

        System.out.print("Введіть масив: ");
        for (int i = 0; i < count; i++) {
            arr[i] = in.nextInt();
        }
        System.out.print("Введіть на скільки елементів змістити масив: ");
        int position = in.nextInt();

        int[] rotatedArray = rotated(arr, position);

        System.out.println("Результат ");
        System.out.println(Arrays.toString(rotatedArray));
    }
    private static int[] rotated(int[] arr, int position) {
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
