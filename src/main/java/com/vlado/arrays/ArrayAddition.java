package com.vlado.arrays;

import java.util.Arrays;

public class ArrayAddition {

  public static void main(String[] args) {
    ArrayAddition addition = new ArrayAddition();

    int[] input = new int[]{0, 9, 9, 9};
    int[] result = addition.addOne(input);

    System.out.println(Arrays.toString(result));
  }

  public int[] addOne(int[] input) {
    int[] result = new int[input.length];
    int carry = 1;
    for (int i = input.length - 1; i >= 0; i--) {
      int current = input[i];
      int sum = current + carry;
      carry = sum / 10;
      result[i] = sum % 10;
    }
    if (carry > 0) {
      int[] modified = new int[result.length + 1];
      modified[0] = carry;
      for (int i = 0; i < result.length; i++) {
        modified[i+1] = result[i];
      }
      result = modified;
    }
    return result;
  }
}
