package com.vlado.strings;

import java.util.function.Supplier;

/**
 * You are given two s: initial and target. The goal of the game is to find a sequence of valid
 * moves that will change initial into target. There are two types of valid moves: Add the letter A
 * to the end of the string. Reverse the string and then add the letter B to the end of the string.
 * Return "Possible" (quotes for clarity) if there is a sequence of valid moves that will change
 * initial into target. Otherwise, return "Impossible".
 */
public class ABBA {

  public static void main(String[] args) {
    System.out.println(new ABBA().canObtain("B", "ABBA")); //Possible
    System.out.println(new ABBA().canObtain("AB", "ABB")); //Impossible
    System.out.println(new ABBA().canObtain("BBAB", "ABABABABB")); // Impossible
    System.out.println(
        new ABBA().canObtain("BBBBABABBBBBBA", "BBBBABABBABBBBBBABABBBBBBBBABAABBBAA")); //Possible
    System.out.println(new ABBA().canObtain("A", "BB")); //Impossible
  }

  public String canObtain(String initial, String target) {
    if (recursive(initial, target)) {
      return "Possible";
    }
    return "Impossible";
  }

  private boolean recursive(String initial, String target) {
    if (initial.length() < target.length()) {
      String modified = addSuffix(initial);
      if (!recursive(modified, target)) {
        modified = reverseAndAddSuffix(initial);
        return recursive(modified, target);
      } else {
        return true;
      }
    }
    return initial.equals(target);
  }

  private String addSuffix(String toString) {
    return toString + "A";
  }

  private String reverseAndAddSuffix(String toString) {
    return new StringBuilder(toString).reverse().append("B").toString();
  }

}
