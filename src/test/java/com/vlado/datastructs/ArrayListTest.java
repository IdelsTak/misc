package com.vlado.datastructs;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by vdimitrov on 6/3/17.
 */
public class ArrayListTest {

    @Test
    public void testResize() {
        ArrayList<Integer> list = new ArrayList<>(2);
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        list.add(1);
        assertEquals(1, list.size());
        list.add(2);
        assertEquals(2, list.size());
        list.add(3);
        assertEquals(3, list.size());
        assertFalse(list.isEmpty());
    }

    @Test
    public void testRemoveByIndex() {
        ArrayList<Integer> list = new ArrayList<>();
        assertEquals(0, list.size());
        list.add(1);
        assertEquals(1, list.size());
        list.add(2);
        assertEquals(2, list.size());
        list.add(3);
        assertEquals(3, list.size());
        list.add(4);
        list.add(5);
        System.out.println(list);
        assertEquals(5, list.size());
        list.remove(3);
        System.out.println(list);
        assertEquals(4, list.size());
    }

    @Test
    public void testRemoveByReference() {
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        assertEquals(1, list.size());
        list.add("two");
        assertEquals(2, list.size());
        list.add("three");
        assertEquals(3, list.size());

        list.remove(null);
        assertEquals(3, list.size());
        list.remove("two");
        assertEquals(2, list.size());
        assertEquals("three", list.get(1));
    }

    @Test
    public void testContains() {
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        assertTrue(list.contains("one"));
        assertFalse(list.contains(null));
        list.remove("one");
        assertFalse(list.contains("one"));
        assertFalse(list.contains(null));
        list.add(null);
        assertTrue(list.contains(null));
        list.remove(null);
        assertFalse(list.contains(null));
    }

    @Test
    public void testIterator() {
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        Iterator<String> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        String next = iterator.next();
        assertEquals("one", next);
        assertFalse(iterator.hasNext());

        list.clear();

        int counter = 0;
        list.add("one");
        list.add("one");
        list.add("one");
        list.add("one");
        iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            counter++;
        }
        assertEquals(4, counter);
    }

    @Test
    public void testToArray() {
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        Object[] array = list.toArray();
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i), array[i]);
        }
    }

    @Test
    public void testClear() {
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        assertEquals(1, list.size());
        list.clear();
        assertEquals(0, list.size());
    }
}
