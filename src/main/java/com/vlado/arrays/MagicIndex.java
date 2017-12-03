package com.vlado.arrays;

/**
 * A magic indesx in an array A[1...n-1] is defined to be an index such that A[i] = i.
 * Given a sorted array of distinct integers, write a method to find a magic index. If it doesn't
 * exist, return -1.
 */
public class MagicIndex {

  public static void main(String[] args) {
    System.out.println(new MagicIndex().findMagixIndex(new int[]{-10, -5, 2, 2, 2, 3, 4, 7, 9,
        12, 13}));
  }

  public int findMagixIndex(int[] array) {
    return findMagixIndex(array, 0, array.length - 1);
  }

  private int findMagixIndex(int[] array, int start, int end) {
    if (start > end) {
      return -1;
    }

    int midIndex = (start + end) / 2;
    int midValue = array[midIndex];

    if (midValue == midIndex) {
      return midIndex;
    }

    //Search left
    int leftIndex = Math.min(midIndex - 1, midValue);
    int left = findMagixIndex(array, start, leftIndex);
    if (left > 0) {
      return left;
    }

    //Search right
    int rightIndex = Math.max(midIndex + 1, midValue);
    int right = findMagixIndex(array, rightIndex, end);

    return right;
  }
}
