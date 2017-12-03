package com.vlado.arrays;

import java.util.Arrays;

public class RotateArray {

  public static void main(String[] args) {
    RotateArray rotator = new RotateArray();

    int[] integers = new int[]{1, 2, 3, 4, 5, 6, 7};
    rotator.rotate(integers, 3);

    System.out.println(Arrays.toString(integers));

  }

  public void rotate(int nums[], int k) {
    if (k > nums.length) {
      k = k - nums.length;
    }

    int[] result = new int[nums.length];
    for (int i = 0; i < k; i++) {
      result[i] = nums[nums.length - k+i];
    }


    for (int i = 0; i < nums.length - k; i++) {
      result[k+i] = nums[i];
    }

    System.arraycopy( result, 0, nums, 0, nums.length );
  }
}
