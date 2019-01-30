package com.company.homework3.mergesort;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] array = {1, 5, 3, -1, 6, 4, 7, 2};
        mergeSort(array, 0, array.length - 1);
        printArray(array);
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
       int start = mid+1;

       if(array[mid]<= array[start]){
           return;
       }

       while (left<=mid && start<=right){
           if(array[left]<= array[start]){
               left++;
           } else {
               int value = array[start];
               int index = start;

               while (index!=left){
                   array[index] = array[index-1];
                   index--;
               }
               array[left] = value;

               left++;
               mid++;
               start++;
           }
       }
    }

    private static void reverse(int[] array, int start, int end){
        int temp = array[start];
        array[start]=array[end];
        array[end]= temp;
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
}
