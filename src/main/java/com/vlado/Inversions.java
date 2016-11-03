package com.vlado;

/**
 * Created by vdimitrov on 10/26/16.
 */
public class Inversions {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 5, 2, 4, 6 };
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    System.out.println(arr[i] + " and " + arr[j] + " are inverted");
                }
            }

        }
    }
}
