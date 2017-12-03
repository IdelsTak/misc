package com.vlado.linkedlist;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 */
public class RemoveNthFromEnd {

  public static void main(String[] args) {
    print(new RemoveNthFromEnd().removeNthFromEnd(asLinkedList(new int[]{1, 2, 3, 4, 5}), 2));
    print(new RemoveNthFromEnd().removeNthFromEnd(asLinkedList(new int[]{1}), 1));
    print(new RemoveNthFromEnd().removeNthFromEnd(asLinkedList(new int[]{1, 2}), 1));
    print(new RemoveNthFromEnd().removeNthFromEnd(asLinkedList(new int[]{1, 2}), 2));
    print(new RemoveNthFromEnd().removeNthFromEnd(asLinkedList(new int[]{1, 2, 3}), 1));
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head.next == null && n == 1) {
      return null;
    }

    ListNode p1 = head;
    ListNode p2 = head;

    for (int i = 0; i < n; i++) {
      p1 = p1.next;
    }

    ListNode prev = null;
    while (p1 != null) {
      prev = p2;
      p1 = p1.next;
      p2 = p2.next;
    }

    if (p2.next == null && prev != null) {
      prev.next = null;
    } else {
      p2.val = p2.next.val;
      p2.next = p2.next.next;
    }


    return head;
  }

  static ListNode asLinkedList(int[] arr) {
    ListNode head = null;
    ListNode current = null;
    for (int i = 0; i < arr.length; i++) {
      ListNode result = new ListNode(arr[i]);
      if (current != null) {
        current.next = result;
        current = result;
      } else {
        current = result;
        head = result;
      }
    }
    return head;
  }

  static void print(ListNode node) {
    while (node != null) {
      System.out.print(node.val + " -> ");
      node = node.next;
    }
    System.out.println();
  }

  static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    public String toString() {
      return String.valueOf(val);
    }
  }

}


