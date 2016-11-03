package com.vlado;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vdimitrov on 10/1/16.
 */
public class WordBreak {
    public static void main(String[] args) {
        WordBreak w = new WordBreak();
        System.out.println(w.wordBreak("abcd", new HashSet<String>(Arrays.asList("a", "abc", "b", "cd"))));
        System.out.println(w.wordBreak("Iamace", new HashSet<String>(Arrays.asList("I", "am", "a", "ace"))));
    }

    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] charCounter = new boolean[s.length() + 1];
        charCounter[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (charCounter[j] && wordDict.contains(s.substring(j, i))) {
                    charCounter[i] = true;
                    break;
                }
            }
        }
        return charCounter[s.length()];
    }
}