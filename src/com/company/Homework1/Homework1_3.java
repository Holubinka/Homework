package com.company.Homework1;

import java.util.Arrays;

public class Homework1_3 {
    public  static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, 3, 5, 8, 9, 10, 13, 14, 15, 16, 28, 29};
        range(arr);
    }

    private  static  void range (int[] arr) {
        int[] temp = Arrays.copyOf(arr, arr.length + 1);
        int count = 0;

        for (int i = 0; i < temp.length - 1; i++) {
            if (temp[i + 1] - temp[i] == 1){
                if(count < 1 ) {
                    System.out.print("[ " + temp[i] + " ");
                }
                count++;
            } else if(temp[i] - temp[i - 1] == 1 ){
                System.out.print(temp[i] + " ] ");
                count = 0;
            } else {
                System.out.print("[ "+temp[i] + " ] ");
                count = 0;
            }
        }
    }
}
