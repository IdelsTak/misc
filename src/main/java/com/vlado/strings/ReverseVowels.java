package com.vlado.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * For a given string, reverse only the vowels.
 */
public class ReverseVowels {


  public static void main(String[] args) {
    System.out.println(new ReverseVowels().reverseVowels("hello")); //should be `holle`
  }

  public String reverseVowels(String s) {
    int left = 0;
    int right = s.length() - 1;

    char[] chars = s.toCharArray();

    while (left < right) {
      if (isVowel(chars[right]) && isVowel(chars[left])) {
        char temp = chars[right];
        chars[right] = chars[left];
        chars[left] = temp;
        left++;
        right--;
      }
      if (!isVowel(chars[left])) {
        left++;
      }
      if (!isVowel(chars[right])) {
        right--;
      }
    }

    return new String(chars);
  }

  private boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'o' || c == 'u' || c == 'i' ||
        c == 'A' || c == 'E' || c == 'O' || c == 'U' || c == 'I';
  }
}
