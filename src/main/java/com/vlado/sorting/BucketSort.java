package com.vlado.sorting;

import java.util.Arrays;

/**
 * Sorting algorithm for strings (radix sort)
 */
public class BucketSort {

  /*Driver function to check for above function*/
  public static void main(String[] args) {
    String[] arr = {"cup", "jaw", "egg", "law", "age", "fox", "job"};
    radixsort(arr);

    System.out.println(Arrays.toString(arr));
  }

  static void radixsort(String[] arr) {
    // Find the maximum number to know number of digits
    int max = getMax(arr);

    // Do counting sort for every digit. Note that instead
    // of passing digit number, exp is passed. exp is 10^i
    // where i is current digit number
    for (int len = 0; len < max; len++) {
      countSort(arr, len);
    }
  }

  // A utility function to get maximum value in arr[]
  static int getMax(String[] arr) {
    int max = 0;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i].length() > max) {
        max = arr[i].length();
      }
    }
    return max;
  }

  // A function to do counting sort of arr[] according to
  // the digit represented by exp.
  static void countSort(String[] arr, int len) {
    String output[] = new String[arr.length]; // output array
    int i;
    //26 alphabets
    int[] count = new int[26];

    // Store count of occurrences in count[]
    for (i = 0; i < arr.length; i++) {
      String word = arr[i];
      //TODO check if charAt is safe for different length of words
      count[word.charAt(len) - 'a']++;
    }

    // Change count[i] so that count[i] now contains
    // actual position of this digit in output[]
    for (i = 1; i < 26; i++) {
      count[i] += count[i - 1];
    }

    // Build the output array
    for (i = arr.length - 1; i >= 0; i--) {
      output[count[(arr[i].charAt(len) - 'a')] - 1] = arr[i];
      count[arr[i].charAt(len) - 'a']--;
//      output[count[(arr[i] / exp) % 10] - 1] = arr[i];
//      count[(arr[i] / exp) % 10]--;
    }

    // Copy the output array to arr[], so that arr[] now
    // contains sorted numbers according to curent digit
    for (i = 0; i < arr.length; i++) {
      arr[i] = output[i];
    }
  }
}
