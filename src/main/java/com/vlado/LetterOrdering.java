package com.vlado;

/**
 * Created by vdimitrov on 10/26/16.
 */
public class LetterOrdering {

    public static void main(String[] args) {
        String order = "abc";
        String input = "aaaabbbbssscc3";

        boolean result = true;
        int index = 0;
        char[] charArray = order.toCharArray();
        for (char c : charArray) {
            int lastIndexOf = input.lastIndexOf(c);
            if (index == 0) {
                index = lastIndexOf;
                continue;
            }
            if (lastIndexOf < index) {
                result = false;
            }
        }

        System.out.println(result);
    }
}
