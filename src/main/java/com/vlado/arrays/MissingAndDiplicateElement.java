package com.vlado.arrays;

import java.util.Arrays;

/**
 * Array with elements from 1 to n, one of them is missing, another is duplicated.
 * For example:
 * <pre>
 *   Input:[3 1 2 5 3]
 *   Output:[3, 4]
 * </pre>
 */
public class MissingAndDiplicateElement {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(new MissingAndDiplicateElement()
        .missingAndDuplicateElement(new int[]{1, 2, 4, 5, 6})));
  }

  public int[] missingAndDuplicateElement(int[] input) {
    int missing = input.length + 1; //5
    for (int i = 0; i < input.length; i++) {
      missing ^= i ^ input[i];
    }
    System.out.println(missing);
    return new int[0];
  }
}