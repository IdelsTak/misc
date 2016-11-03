package com.vlado;

import java.util.Arrays;

/**
 * Created by vdimitrov on 10/26/16.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 5, 2, 4, 6 };
        new InsertionSort().doSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void doSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
}
