package com.vlado.linkedlist;

/**
 * Check if a linked list is a palindrome
 */
public class Palindrome {

    public static void main(String[] args) {
        System.out.println(new Palindrome().isPalindrome(arrayToLinkedList(0, 1, 2, 1, 0))); //true
        System.out.println(new Palindrome().isPalindrome(arrayToLinkedList(0, 1, 2, 2, 0))); //false
    }

    boolean isPalindrome(LinkedListNode head) {
        LinkedListNode reversed = reverseAndClone(head);
        return areEqual(head, reversed);
    }

    LinkedListNode reverseAndClone(LinkedListNode node) {
        LinkedListNode head = null;
        while (node != null) {
            LinkedListNode n = new LinkedListNode(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    private boolean areEqual(LinkedListNode one, LinkedListNode two) {
        while (one != null && two != null) {
            if (one.data != two.data){
                return false;
            }
            one = one.next;
            two = two.next;
        }
        return one == null && two == null;
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

    static void printLinkedList(LinkedListNode n) {
        while (n != null) {
            if (n.next != null) {
                System.out.print(n.data + " -> ");
            } else {
                System.out.print(n.data);
            }
            n = n.next;
        }
        System.out.println();
    }

    static class LinkedListNode {
        int data;
        LinkedListNode next;

        LinkedListNode(int data) {
            this.data = data;
        }
    }
}
