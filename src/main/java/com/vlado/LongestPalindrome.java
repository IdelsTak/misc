package com.vlado;

public class LongestPalindrome {

    public static void main(String[] args) {
//        System.out.println(new LongestPalindrome().longestPalindrome("babad"));
//        System.out.println(new LongestPalindrome().longestPalindrome("ccc"));
//        System.out.println(new LongestPalindrome().longestPalindrome("abcda"));
        System.out.println(new LongestPalindrome().longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        char[] charArr = s.toCharArray();
        String result = s.substring(0,1);

        for (int i = 0; i < charArr.length - 1; i++) {
            for (int j = charArr.length - 1; j >= i; j--) {
                if (isPalindrome(charArr, i, j) && j - i > result.length()) {
                    result = s.substring(i, j + 1);
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(char[] chars, int start, int end) {
        for (int i = 0; i < end - start; i++) {
            if (chars[start + i] != chars[end - i]) {
                return false;
            }
        }
        return true;
    }
}
