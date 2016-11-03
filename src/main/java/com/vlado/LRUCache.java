package com.vlado;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vdimitrov on 10/1/16.
 */
public class LRUCache {

    class Node {
        int key;
        int value;

        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "[" + key + "=" + value + "]";
        }
    }

    private final int capacity;
    private final Map<Integer, Node> nodeMap;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<Integer, Node>(capacity);
    }

    public int get(int key) {
        Node n = nodeMap.get(key);
        if (n == null) {
            return -1;
        }
        remove(n);
        setAsHead(n);
        return n.value;
    }

    public void set(int key, int value) {
        Node node = nodeMap.get(key);
        if (node == null) {
            if (nodeMap.size() >= capacity) {
                nodeMap.remove(tail.key);
                remove(tail);
            }

            node = new Node(key, value);
            nodeMap.put(key, node);
            setAsHead(node);

        } else {
            node.value = value;
            remove(node);
            setAsHead(node);
        }
//        System.out.println("SET: map current state: " + nodeMap.toString());
//        System.out.print("SET: ");
//        printList();
    }

    private void printList() {
        System.out.print(tail);
        Node n;
        int counter = 100;
        while (tail != null && counter > 0) {
            counter --;
            n = tail.next;
            if (n == null) {
                break;
            }
            System.out.print(n);
        }
        System.out.println();
    }

    private void remove(Node node) {
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            head = node.prev;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            tail = node.next;
        }

    }

    private void setAsHead(Node node) {
        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        node.next = null;
        node.prev = head;

        head.next = node;
        head = node;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.set(2, 1);
        cache.set(1, 1);
        System.out.println(cache.get(2));
        cache.set(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
