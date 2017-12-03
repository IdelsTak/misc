package com.vlado;

public class PermutationsOfString {

  public static void main(String args[]) {
    System.out.println(count("12345"));
  }

  public static int count(String str) {
    int n = str.length();
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

}
