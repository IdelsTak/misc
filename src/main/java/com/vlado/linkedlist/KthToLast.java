package com.vlado.linkedlist;

/**
 * Find the k-th to last element of a singly linked list
 */
public class KthToLast {

    public static void main(String[] args) {
        System.out.println(new KthToLast().kthToLast(arrayToLinkedList(new int[]{1, 2, 3, 4, 5, 6}), 3).data);
    }

    LinkedListNode kthToLast(LinkedListNode head, int k) {
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        for (int i = 0; i < k; i++) {
            if (p1 == null) {
                //Out of bounds
                return null;
            }
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    static LinkedListNode arrayToLinkedList(int[] arr) {
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
