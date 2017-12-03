package com.vlado.bits;

/**
 * Given a real number between 1 and 0, print the binary representation
 */
public class BinaryToString {

  public static void main(String[] args) {
    System.out.println((51 & 1) != 0);

    System.out.println(new BinaryToString().printBinary(0.1));
  }

  public String printBinary(double num) {
    if (num >= 1 || num <= 0) {
      return "ERROR";
    }

    StringBuilder binary = new StringBuilder(".");
    while (num > 0) {
      if (binary.length() >= 32) {
        return "ERROR";
      }

      double r = num * 2;
      if (r >= 1) {
        binary.append(1);
        num = r - 1;
      } else {
        binary.append(0);
        num = r;
      }
    }
    return binary.toString();
  }
}
