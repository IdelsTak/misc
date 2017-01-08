package com.vlado.strings;

/**
 * Determine if a string has all unique characters
 */
public class UniqueCharacters {

    public static void main(String[] args) {
        System.out.println(new UniqueCharacters().isUniqueChars("abcdefghijklmnop"));//true
        System.out.println(new UniqueCharacters().isUniqueChars("abcdefc"));//false
        System.out.println(new UniqueCharacters().isUniqueChars("vladimir"));//false
    }

    /**
     * Resolved this by using a mask
     */
    boolean isUniqueChars(String str) {
        int mask = 0;

        for (int i = 0; i < str.length(); i++) {
            System.out.println("mask: " + Integer.toBinaryString(mask));
            int code = str.charAt(i) - 'a';
            if ((mask & (1 << code)) > 0) {
                return false;
            }
            mask |= (1 << code);
        }
        return true;
    }

}
