package com.company.Homework1;

import java.util.Arrays;

public class Homework1_1 {

    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 6, 7, 9};
        int position = 5;

        rotated(arr, position);
    }

    private static  void rotated (int[] arr, int position){
        int [] temp = Arrays.copyOf(arr, arr.length);

        for (int i = 0; i < temp.length; i++){
            if(i < position){
                arr [arr.length - position + i] = temp[i];
            } else {
                arr [i - position] = temp[i];
            }
        }

        for (Integer list : arr) {
            System.out.print(list + " ");
        }
    }
}
