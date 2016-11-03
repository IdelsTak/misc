package com.vlado;

/**
 * Created by vdimitrov on 10/26/16.
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        //DOESN'T WORK
        System.out.println(longestIncreasingSubsequence(new int[]{1, 2, 3})); //should be 3
        System.out.println(longestIncreasingSubsequence(new int[]{1, 4, 3})); //should be 2
        System.out.println(longestIncreasingSubsequence(new int[]{1, 4, 5, 2, 6})); //should be 4
        System.out.println(longestIncreasingSubsequence(new int[]{2, 3, 3, 5})); //should be 3
        System.out.println(longestIncreasingSubsequence(new int[]{2, 3, 3, 5, 8, 7})); //should be 4
        System.out.println(longestIncreasingSubsequence(new int[]{3, 4, -1, 0, 6, 2, 3})); //should be 4
    }

    public static int longestIncreasingSubsequence(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < (dp[j] + 1)) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }

        int max = 1;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
