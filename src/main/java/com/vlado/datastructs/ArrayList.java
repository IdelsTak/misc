package com.vlado.datastructs;

import java.util.*;

/**
 * Created by vdimitrov on 6/3/17.
 */
class ArrayList<T> implements List<T> {

    private static final int DEFAULT_SIZE = 10;

    private Object[] elements;
    private int size;

    public ArrayList() {
        this(DEFAULT_SIZE);
    }

    public ArrayList(int initialCapacity) {
        if (initialCapacity >= 0) {
            elements = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Invalid ArrayList size: " + initialCapacity);
        }
    }

    @Override
    public T get(int index) {
        rangeCheck(index);
        return elementData(index);
    }

    @Override
    public T set(int index, T element) {
        rangeCheck(index);
        T oldValue = elementData(index);
        elements[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        rangeCheck(index);
        T oldValue = elementData(index);

        int elementsToMove = size - index - 1;
        if (elementsToMove > 0) {
            System.arraycopy(elements, index + 1, elements, index, elementsToMove);
        }
        elements[size--] = null;

        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new InternalIterator<>();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    public boolean add(T element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                T element = elementData(i);
                if (element == null) {
                    remove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                T element = elementData(i);
                if (o.equals(element)) {
                    remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for(int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            Object element = elements[i];
            if (element != null) {
                sb.append(element.toString());
            } else {
                sb.append("null");
            }

            if (i < size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void rangeCheck(int index) {
        if (index >= elements.length) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size();
    }

    @SuppressWarnings("unchecked")
    private T elementData(int index) {
        return (T) elements[index];
    }

    private void ensureCapacity(int desiredLength) {
        if (desiredLength - elements.length > 0) {
            grow(desiredLength);
        }
    }

    private void grow(int desiredLength) {
        //FIXME overflow not handled
        elements = Arrays.copyOf(elements, desiredLength);
    }

    private class InternalIterator<T> implements Iterator {
        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public Object next() {
            return elementData(cursor++);
        }
    }
}
