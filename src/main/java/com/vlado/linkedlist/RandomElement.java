package com.vlado.linkedlist;

import java.util.Random;

/**
 * Return a random element from the list with equal probability
 */
public class RandomElement {

    public static void main(String[] args) {
        LinkedListNode head = arrayToLinkedList(1, 2, 3, 4, 5, 6, 7);

        System.out.println(new RandomElement(head).getRandom());
    }

    private LinkedListNode head = null;
    private Random random;

    public RandomElement(LinkedListNode head) {
        this.head = head;
        this.random = new Random();
    }

    public int getRandom() {
        LinkedListNode result = null;
        LinkedListNode current = head;

        for (int i = 1; current != null; i++) {
            if (random.nextInt(i) == 0) {
                result = current;
            }
            current = current.next;
        }

        return result.data;
    }

    static LinkedListNode arrayToLinkedList(int... arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        LinkedListNode start = new LinkedListNode(arr[0]);
        if (arr.length > 1) {
            LinkedListNode last = start;
            for (int i = 1; i < arr.length; i++) {
                LinkedListNode node = new LinkedListNode(arr[i]);
                last.next = node;
                last = node;
            }
        }
        return start;
    }

    static class LinkedListNode {
        int data;
        LinkedListNode next;

        LinkedListNode(int data) {
            this.data = data;
        }
    }
}
