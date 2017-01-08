package com.vlado.strings;

/**
 *
 */
public class StringRotation {

    public static void main(String[] args) {
        System.out.println(new StringRotation().isRotation("waterbottle", "erbottlewat")); //true
    }

    boolean isRotation(String s1, String s2) {
        if (s1.length() == s2.length()) {
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }

    /**
     * Checks if s1 is a substring of s2
     */
    boolean isSubstring(String s1, String s2) {
        return s1.indexOf(s2) > 0;
    }
}
