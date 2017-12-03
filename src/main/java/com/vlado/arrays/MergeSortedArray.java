package com.vlado.arrays;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array. You
 * may assume that nums1 has enough space (size that is greater or equal to m + n) to hold
 * additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n
 * respectively.
 */
public class MergeSortedArray {

  public static void main(String[] args) {
    int[] input = new int[]{1, 0};
    new MergeSortedArray().merge(input, 1, new int[]{2}, 1);

    System.out.println(Arrays.toString(input));
  }

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    if (n == 0) {
      return;
    }

    int last1 = m - 1;
    int last2 = n - 1;
    int mergedIndex = nums1.length - 1;

    while (last2 >= 0) {
      if (last1 >= 0 && nums1[last1] > nums2[last2]) {
        nums1[mergedIndex] = nums1[last1];
        last1--;
      } else {
        nums1[mergedIndex] = nums2[last2];
        last2--;
      }
      mergedIndex--;
    }
  }

}
