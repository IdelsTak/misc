package com.vlado;

import java.util.Arrays;

/**
 * Created by vdimitrov on 10/26/16.
 */
public class MergeSort {

    public static int inversions = 0;

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 5, 2, 4, 6 };

        MergeSort sorter = new MergeSort();
        System.out.println("Sorted arr: " + Arrays.toString(sorter.mergeSort(arr)));
        System.out.println("Number of inversions: " + inversions);
    }

    public int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int[] left = new int[arr.length / 2];
        int[] right = new int[arr.length - left.length];

        System.arraycopy(arr, 0, left, 0, left.length);
        System.arraycopy(arr, left.length, right, 0, right.length);

        mergeSort(left);
        mergeSort(right);

        return merge(left, right);
    }

    public int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int leftIndex = 0;
        int rightIndex = 0;
        int resIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                result[resIndex] = left[leftIndex];
                leftIndex++;
            } else {
                result[resIndex] = right[rightIndex];
                rightIndex++;
                inversions++;
            }
            resIndex++;
        }

        System.arraycopy(left, leftIndex, result, resIndex, left.length - leftIndex);
        System.arraycopy(right, rightIndex, result, resIndex, right.length - rightIndex);
        return result;
    }

}
