package com.vlado.datastructs;

import java.util.*;

/**
 * Created by vdimitrov on 6/3/17.
 */
class HashMap<K, V> implements Map<K, V> {

    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 3;

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    //The next size value at which to resize (capacity * load factor).
    private int threshold;
    final float loadFactor;
    private int size;

    private LinkedList<Entry>[] elements;

    public HashMap() {
        elements = new LinkedList[DEFAULT_INITIAL_CAPACITY];
        loadFactor = DEFAULT_LOAD_FACTOR;
        updateThreshold();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        Map.Entry entry = getEntryOrNull(key, false);

        return entry != null ? (V) entry.getValue() : null;
    }

    private int index(int hash) {
        return hash & elements.length - 1;
    }

    @Override
    public V put(K key, V value) {
        if (size + 1 > threshold) {
            resize();
        }

        int hash = key.hashCode();
        int index = index(hash);
        LinkedList<Entry> andGetList = createAndGetList(index);
        putElementIfAbsent(key, value, hash, andGetList);
        return value;
    }

    private Map.Entry getEntryOrNull(Object key, boolean remove) {
        if (key == null) {
            return null;
        }

        int hash = key.hashCode();
        int index = index(hash);
        LinkedList<Entry> andGetList = createAndGetList(index);

        Map.Entry entry = getElement(key, andGetList, remove);
        return entry;
    }

    private void resize() {
        int newSize = elements.length << 1;

        LinkedList<Entry>[] oldElements = elements;
        elements = new LinkedList[newSize];

        for (int i = 0; i < oldElements.length; i++) {
            LinkedList<Entry> oldList = oldElements[i];
            if (oldList != null) {
                for (int j = 0; j < oldList.size(); j++) {
                    Entry entry = oldList.get(j);
                    oldList.set(j, null);

                    int hash = entry.getKey().hashCode();
                    int index = index(hash);

                    LinkedList<Entry> andGetList = createAndGetList(index);
                    andGetList.add(entry);
                }
                oldElements[i] = null;
            }
        }
        updateThreshold();
    }

    @Override
    public V remove(Object key) {
        Map.Entry entry = getEntryOrNull(key, true);
        size--;
        return (V)entry.getValue();
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {
        for (LinkedList<Entry> list : elements) {
            if (list != null) {
                list.clear();
            }
        }
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("size: ");
        sb.append(elements.length);
        sb.append("\n");
        for (int i = 0; i < elements.length; i++) {
            LinkedList<Entry> element = elements[i];
            sb.append(i);
            sb.append("=>");
            if (element == null) {
                sb.append("null");
            } else {
                for (int j = 0; j < element.size(); j++) {
                    sb.append(element.get(j));
                    if (j < element.size() - 1) {
                        sb.append(",");
                    }
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private void updateThreshold() {
        threshold = (int)(elements.length * loadFactor);
    }

    private LinkedList<Entry> createAndGetList(int index) {
        LinkedList<Entry> list = elements[index];
        if (list == null) {
            list = elements[index] = new LinkedList<>();
        }
        return list;
    }

    private void putElementIfAbsent(K key, V value, int hash, LinkedList<Entry> list) {
        boolean found = false;
        for (int i = 0; i < list.size(); i++) {
            Entry e = list.get(i);
            if (e.key.equals(key)) {
                list.set(i, new Entry(hash, key, value));
                found = true;
                break;
            }
        }
        if (!found) {
            list.add(new Entry(hash, key, value));
            size++;
        }
    }

    private Map.Entry getElement(Object key, LinkedList<Entry> list, boolean remove) {
        for (int i = 0; i < list.size(); i++) {
            Entry entry = list.get(i);
            if (entry.key.equals(key)) {
                if (remove) {
                    list.remove(i);
                }
                return entry;
            }
        }
        return null;
    }

    private static class Entry<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;

        protected Entry(int hash, K key, V value) {
            this.hash = hash;
            this.key =  key;
            this.value = value;
        }

        // Map.Entry Ops

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            if (value == null)
                throw new NullPointerException();

            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry<?,?> e = (Map.Entry<?,?>)o;

            return (key==null ? e.getKey()==null : key.equals(e.getKey())) &&
                    (value==null ? e.getValue()==null : value.equals(e.getValue()));
        }

        public int hashCode() {
            return hash ^ Objects.hashCode(value);
        }

        public String toString() {
            return key.toString()+"="+value.toString();
        }
    }
}
