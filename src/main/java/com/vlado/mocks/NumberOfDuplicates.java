package com.vlado.mocks;

/**
 * In a sorted integer array, find how many times a number is repeated.
 */
public class NumberOfDuplicates {

  public static void main(String[] args) {
    int[] arr = new int[]{1, 3, 5, 8, 8, 8, 8, 8, 9, 15, 19};

    System.out.println(new NumberOfDuplicates().numberOfOccurences(arr, 8));
  }

  public int numberOfOccurences(int[] arr, int number) {
    int first = first(arr, 0, arr.length-1,  number);
    if (first == -1) {
      return first;
    }
    int last = last(arr, 0, arr.length-1, number);

    return last - first + 1;
  }

  private int first(int[] arr, int low, int high, int number) {
    if (high >= low) {
      int mid = (high + low) / 2;
      if ((mid == 0 || number > arr[mid - 1]) && arr[mid] == number ) {
        return mid;
      } else if (number > arr[mid]) {
        return first(arr, mid + 1, high, number);
      } else {
        return first(arr, low, mid - 1, number);
      }
    }
    return -1;
  }

  private int last(int[] arr, int low, int high, int number) {
    if (high >= low) {
      int mid = (high + low) / 2;
      if ((mid == arr.length - 1 || number < arr[mid + 1]) && arr[mid] == number ) {
        return mid;
      } else if (number < arr[mid]) {
        return last(arr, low, mid - 1, number);
      } else {
        return last(arr, mid + 1, high, number);
      }
    }
    return -1;
  }

}
