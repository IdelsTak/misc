package com.vlado.datastructs;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vdimitrov on 7/11/17.
 */
public class TrieTest {

    @Test
    public void simpleTest() {
        Trie trie = new Trie();
        trie.insert("work");
        Assert.assertTrue(trie.search("work"));
    }

    @Test
    public void testMultiple() {
        Trie trie = new Trie();
        trie.insert("work");
        trie.insert("workload");
        trie.insert("cat");

        Assert.assertTrue(trie.search("work"));
        Assert.assertTrue(trie.search("workload"));
        Assert.assertTrue(trie.search("cat"));
    }

    @Test
    public void testMultipleReversed() {
        Trie trie = new Trie();
        trie.insert("workload");
        trie.insert("work");

        Assert.assertTrue(trie.search("work"));
        Assert.assertTrue(trie.search("workload"));
    }

    @Test
    public void testStartsWith() {
        Trie trie = new Trie();
        trie.insert("workload");

        Assert.assertTrue(trie.startsWith("workl"));
        Assert.assertFalse(trie.startsWith("workw"));
        Assert.assertFalse(trie.startsWith("test"));
    }

    @Test
    public void testGetWordsStartingWith() {
        Trie trie = new Trie();
        trie.insert("work");
        trie.insert("workload");
        trie.insert("workforce");
        trie.insert("word");

        System.out.println(trie.startsWith("wo", 2));
    }
}
