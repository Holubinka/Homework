package com.holubinka.homework3.mergesort;

public class Sorting {
    public void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    public void merge(int[] array, int left, int mid, int right) {
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
}
