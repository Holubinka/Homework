package com.company.homework3.mergesort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sorting {
    public static void main(String[] args) {
        try {
            int[] array = enterArr();
            mergeSort(array, 0, array.length - 1);
            printArray(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int start = mid + 1;

        if (array[mid] <= array[start]) {
            return;
        }

        while (left <= mid && start <= right) {
            if (array[left] <= array[start]) {
                left++;
            } else {
                int value = array[start];
                int index = start;

                while (index != left) {
                    array[index] = array[index - 1];
                    index--;
                }
                array[left] = value;

                left++;
                mid++;
                start++;
            }
        }
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static int[] enterArr() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Введіть розмірність масива: ");
        int count = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[count];

        System.out.print("Введіть масив: ");
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }
        return arr;
    }
}
