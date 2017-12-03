package com.vlado.sorting;

import java.util.Arrays;

/**
 * Created by vdimitrov on 11/20/17.
 */
public class Radix {

  /*Driver function to check for above function*/
  public static void main(String[] args) {
    int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
    radixsort(arr);

    System.out.println(Arrays.toString(arr));
  }

  static void radixsort(int arr[]) {
    // Find the maximum number to know number of digits
    int m = getMax(arr);

    // Do counting sort for every digit. Note that instead
    // of passing digit number, exp is passed. exp is 10^i
    // where i is current digit number
    for (int exp = 1; m / exp > 0; exp *= 10) {
      countSort(arr, exp);
    }
  }

  // A utility function to get maximum value in arr[]
  static int getMax(int arr[]) {
    int mx = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > mx) {
        mx = arr[i];
      }
    }
    return mx;
  }

  // A function to do counting sort of arr[] according to
  // the digit represented by exp.
  static void countSort(int arr[], int exp) {
    int output[] = new int[arr.length]; // output array
    int i;
    int count[] = new int[10];
    Arrays.fill(count, 0);

    // Store count of occurrences in count[]
    for (i = 0; i < arr.length; i++) {
      count[(arr[i] / exp) % 10]++;
    }

    // Change count[i] so that count[i] now contains
    // actual position of this digit in output[]
    for (i = 1; i < 10; i++) {
      count[i] += count[i - 1];
    }

    // Build the output array
    for (i = arr.length - 1; i >= 0; i--) {
      output[count[(arr[i] / exp) % 10] - 1] = arr[i];
      count[(arr[i] / exp) % 10]--;
    }

    // Copy the output array to arr[], so that arr[] now
    // contains sorted numbers according to curent digit
    for (i = 0; i < arr.length; i++) {
      arr[i] = output[i];
    }
  }

}
