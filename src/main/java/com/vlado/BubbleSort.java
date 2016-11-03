package com.vlado;

import java.util.Arrays;

/**
 * Created by vdimitrov on 10/26/16.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 5, 2, 4, 6 };

        new BubbleSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}