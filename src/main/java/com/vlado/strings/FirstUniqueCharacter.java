package com.vlado.strings;

public class FirstUniqueCharacter {

  public static void main(String[] args) {
    System.out.println(new FirstUniqueCharacter().firstUniqChar("lleetcode"));
  }

  int[] count = new int[26];

  public int firstUniqChar(String s) {
    char[] chars = s.toCharArray();
    for (Character c : chars) {
      count[c -'a'] += 1;
    }

    for (int i = 0; i < chars.length; i++) {
      if (count[chars[i] - 'a'] == 1) {
        return i;
      }
    }
    return -1;
  }
}
