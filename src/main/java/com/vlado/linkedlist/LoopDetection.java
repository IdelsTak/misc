package com.vlado.linkedlist;

/**
 * Detect if a linked list has a loop
 * 1 -> 2 -> 3 -> 4 -> 5
 *           ^        /
 *           \_______/
 */
public class LoopDetection {

    public static void main(String[] args) {

        LinkedListNode[] nodes = arrayToLinkedList(new int[]{1, 2, 3, 4, 5}, 3);

        LinkedListNode head = nodes[0];
        LinkedListNode tail = nodes[1];
        LinkedListNode loopStart = nodes[2];
        tail.next = loopStart;

        System.out.println(new LoopDetection().findBeginningOfLoop(head).data); //3
    }

    LinkedListNode findBeginningOfLoop(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //Loop detected
            if (slow == fast) {
                break;
            }
        }

        //Checkpoint
        if (fast == null || fast.next == null) {
            return null;
        }

        /*
         * Move slow to head. Keep fast at meeting point. Each are k steps from the Loop start.
         * If they move at the same pace, they must meet at Loop Start.
         */
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    static LinkedListNode[] arrayToLinkedList(int[] arr, int c) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        LinkedListNode start = new LinkedListNode(arr[0]);
        LinkedListNode result = null;
        LinkedListNode end = null;
        if (arr.length > 1) {
            LinkedListNode last = start;
            for (int i = 1; i < arr.length; i++) {
                LinkedListNode node = new LinkedListNode(arr[i]);
                last.next = node;
                last = node;
                if (arr[i] == c) {
                    result = node;
                }
                end = last;
            }
        }
        return new LinkedListNode[]{start, end, result};
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
