package com.vlado.stacks;

import java.util.Stack;

/**
 * Sort a stack, so that the smallest elements are on top.
 * Only an additional empty stack can be used.
 */
public class SortStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(7);
        stack.push(10);
        stack.push(5);
        stack.push(12);

        new SortStack().sort(stack);

        printStack(stack);
    }

    void sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<>();
        while (!s.empty()) {
            Integer temp = s.pop();
            while (!r.isEmpty() && r.peek() > temp) {
                s.push(r.pop());
            }
            r.push(temp);
        }
        while (!r.isEmpty()) {
            s.push(r.pop());
        }
    }

    static void printStack(Stack stack) {
        stack = (Stack) stack.clone();
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " -> ");
        }
        System.out.println();
    }
}
