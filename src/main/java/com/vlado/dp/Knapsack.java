package com.vlado.dp;

import static java.lang.Math.*;

public class Knapsack {

  public static void main(String[] args) {
    int[] weight =  {0, 1, 2, 4, 2, 5};
    int[] value =   {0, 5, 3, 5, 3, 2};

    Knapsack knapsack = new Knapsack(weight, value);
    System.out.println(knapsack.maxValue());
  }

  private final int weight[];
  private final int value[];
  private Integer[][] dp;
  private static final int CAPACITY = 10;

  public Knapsack(int[] weight, int[] value) {
    this.weight = weight;
    this.value = value;
    dp = new Integer[value.length][CAPACITY + 1];
  }

  public int maxValue() {
    int result = ks(value[value.length - 1], CAPACITY);

    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        System.out.print(dp[i][j] != null ? dp[i][j] + '\t' : "x\t");
      }
      System.out.println();
    }
    return result;
  }

  private int ks(int index, int capacityLeft) {
    if (dp[index][capacityLeft] != null) {
      return dp[index][capacityLeft];
    }
    int result;
    if (index == 0 || capacityLeft == 0) {
      //We don't have any room left
      result = 0;
    } else if (weight[index]> capacityLeft) {
      //Skip this index
      result = ks(index - 1, capacityLeft);
    } else {
      int temp1 = ks(index - 1, capacityLeft);
      int temp2 = value[index] + ks(index - 1, capacityLeft - weight[index]);
      result = max(temp1, temp2);
    }
    dp[index][capacityLeft] = result;
    return result;
  }

}
