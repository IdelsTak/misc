package com.vlado.strings;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid
 * (well-formed) parentheses substring. For "(()", the longest valid parentheses substring is "()",
 * which has length = 2. Another example is ")()())", where the longest valid parentheses substring
 * is "()()", which has length = 4.
 */
public class LongestValidParentheses {

  public static void main(String[] args) {
    System.out.println(new LongestValidParentheses().longestValidParentheses(")()())"));//4
    System.out.println(new LongestValidParentheses().longestValidParentheses("("));//0
    System.out.println(new LongestValidParentheses().longestValidParentheses("(()"));//2
  }

  public int longestValidParentheses(String s) {
    char[] chars = s.toCharArray();
    int max = 0, left = 0, right = 0;

    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      if (c == '(') {
        left++;
      } else {
        right++;
      }

      if (left == right) {
        max = Math.max(max, right * 2);
      } else if (right >= left) {
        left = right = 0;
      }
    }
    left = right = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      char c = chars[i];
      if (c == '(') {
        left++;
      } else {
        right++;
      }

      if (left == right) {
        max = Math.max(max, left * 2);
      } else if (left >= right) {
        left = right = 0;
      }
    }
    return max;
  }
}
