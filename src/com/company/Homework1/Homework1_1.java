package com.company.Homework1;

import java.util.Arrays;
import java.util.Scanner;

public class Homework1_1 {

    public static void main(String[] args) {
        int count, position;
        int [] arr, copied;
        //int[] arr = {5, 6, 1, 2, 6};
        Scanner in = new Scanner(System.in);

        System.out.print("Введіть розмірність масива: ");
        count = in.nextInt();
        arr = new int[count];

        System.out.print("Введіть масив: ");
        for (int i = 0; i < count; i++ ){
            arr [i] = in.nextInt();
        }
        System.out.print("Введіть на скільки елементів змістити масив: ");
        position = in.nextInt();

        copied = rotated(arr, position);

        System.out.println("Результат ");
        System.out.println(Arrays.toString(copied));
    }
    private static  int [] rotated (int[] arr, int position){
        int [] temp = Arrays.copyOf(arr, arr.length);

        for (int i = 0; i < temp.length; i++){
            if (i < position){
                arr [arr.length - position + i] = temp[i];
            } else {
                arr [i - position] = temp[i];
            }
        }
        return arr;
    }
}
