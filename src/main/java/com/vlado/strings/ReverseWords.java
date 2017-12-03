package com.vlado.strings;

public class ReverseWords {

  public static void main(String[] args) {
    ReverseWords reverser = new ReverseWords();

    char[] arr = "blue is the sky".toCharArray();
    reverser.reverseWords(arr);
    System.out.println(arr);

  }

  public void reverseWords(char[] s) {
    int wordStart = 0;
    for (int j = wordStart; j < s.length; j++) {
      if(s[j] == ' ') {
        reverse(s, wordStart, j - 1);
        wordStart = j + 1;
      }
    }

    reverse(s, wordStart, s.length - 1);

    reverse(s, 0, s.length - 1);
  }

  private void reverse(char[] s, int start, int end) {
    while(start < end) {
      char temp = s[end];
      s[end] = s[start];
      s[start] = temp;
      start++;
      end--;
    }
  }
}
