package com.vlado.arrays;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Example:
 * Input: 123
 * Output:  321
 */
public class ReverseInteger {

  public static void main(String[] args) {
    System.out.println(new ReverseInteger().reverse(123));
    System.out.println(new ReverseInteger().reverse(-45));
    System.out.println(new ReverseInteger().reverse(1534236469));
  }

  public int reverse(int x) {
    int result = 0;
    while (x != 0) {
      int tail = x % 10;
      int newResult = (result * 10) + tail;
      if ((newResult - tail)/10 != result) {
        return 0;
      }
      result = newResult;
      x = x / 10;
    }
    return result;
  }

}
