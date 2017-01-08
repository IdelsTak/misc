package com.vlado.strings;

/**
 * Implement a method to perform basic string compression using the count of repeated characters
 */
public class StringCompression {

    public static void main(String[] args) {
        System.out.println(new StringCompression().compress("aabcccccaaa")); //a2b1c5a3
        System.out.println(new StringCompression().compress("abcdefg")); //abcdefg
    }

    String compress(String str) {
        if (countCompression(str) >= str.length()) {
            return  str;
        }

        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;
            if (i + 1 >= str.length() || str.charAt(i + 1) != str.charAt(i)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.length() >= str.length() ? str : compressed.toString();
    }

    int countCompression(String str) {
        int countConsecutive = 0;
        int compressedLength = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;
            if (i + 1 >= str.length() || str.charAt(i + 1) != str.charAt(i)) {
                compressedLength += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }
        return compressedLength;
    }
}
