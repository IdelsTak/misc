package com.vlado.strings;

/**
 * Replace all spaces in a string with '%20'
 */
public class URLify {

    public static void main(String[] args) {
        String s = "Mr John Smith    ";
        char[] chars = s.toCharArray();
        new URLify().replaceSpaces(chars, 13);
        System.out.println(chars);

    }

    void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        int index = trueLength + spaceCount * 2;

        for (int i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index --;
            }
        }
    }
}
