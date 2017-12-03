package com.vlado.strings;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {

  public static void main(String[] args) {
    System.out.println(new ValidParentheses().isValid("()[]{}"));
  }

  public boolean isValid(String s) {
    char[] chars = s.toCharArray();
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == ')') {
        if (stack.empty() || stack.pop() != '(') {
          return false;
        }
      } else if (chars[i] == '}') {
        if (stack.empty() || stack.pop() != '{') {
          return false;
        }
      } else if (chars[i] == ']') {
        if (stack.empty() || stack.pop() != '[') {
          return false;
        }
      } else {
        stack.push(chars[i]);
      }
    }
    return stack.isEmpty();
  }
}
