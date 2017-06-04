package com.vlado.datastructs;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by vdimitrov on 6/3/17.
 */
public class HashMapTest {

    @Test
    public void testRemove() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        assertEquals(1, map.size());
        map.remove("one");
        assertEquals(0, map.size());
        assertNull(map.get("one"));
    }

    @Test
    public void testClear() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        assertEquals(1, map.size());
        map.put("one", 1);
        map.put("two", 1);
        map.put("three", 1);
        map.put("four", 1);
        map.put("five", 1);
        map.clear();
        assertEquals(0, map.size());
        assertNull(map.get("one"));
    }

    @Test
    public void testResize() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        System.out.println(map.toString());
        //Will trigger reindexing
        map.put("seven", 7);
        System.out.println(map.toString());
    }

    @Test
    public void testPutAndGet() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        assertEquals(1, map.size());
        map.put("two", 2);
        assertEquals(2, map.size());
        map.put("three", 3);
        assertEquals(3, map.size());
        map.put("four", 4);
        assertEquals(4, map.size());
        map.put("two", 22);
        assertEquals(4, map.size());

        System.out.println(map);

        System.out.println(map.get("one"));
        System.out.println(map.get("two"));
        System.out.println(map.get("three"));
        System.out.println(map.get("four"));
    }
}
