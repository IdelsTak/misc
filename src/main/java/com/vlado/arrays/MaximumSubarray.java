package com.vlado.arrays;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the
 * largest sum. For example, given the array
 * <p>
 * [-2,1,-3,4,-1,2,1,-5,4],
 * </p>
 * the contiguous subarray
 * <p>
 * [4,-1,2,1]
 * </p>
 * has the largest sum = 6.
 */
public class MaximumSubarray {

  public static void main(String[] args) {
    System.out.println(new MaximumSubarray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
  }

  public int maxSubArray(int[] nums) {
    int maxSoFar = nums[0], maxEndingHere = nums[0];
    for (int i = 1; i < nums.length; ++i) {
      maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
      maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }
    return maxSoFar;
  }
}
