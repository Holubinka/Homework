package com.company.Homework1;

import java.util.Arrays;

public class Homework1_2 {
    public  static void main(String[] args) {
        int[] arr = {1, 2, -1, 4, 7, 6, -2, 4};
        restore(arr);
    }

    private  static  void restore(int[] arr){
        int [] temp = Arrays.copyOf(arr, arr.length);

        for (int i = 2; i < temp.length; i++){
            if(temp[i] - temp[i - 2] == 2 && temp[i - 1] < 0 ){
                temp[i - 1] = temp[i] - 1;
            }
            if(temp[i] - temp[i - 2] == -2 && temp[i - 1] < 0 ){
                temp[i - 1] = temp[i] + 1;
            }
        }
        for (Integer list : temp) {
            System.out.print(list + " ");
        }
    }
}
