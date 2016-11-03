package com.vlado;

import java.util.Arrays;

/**
 * Created by vdimitrov on 10/26/16.
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 5, 2, 4, 6 };
        new SelectionSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    minIndex = j;
                }
            }
            int min = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
    }
}
