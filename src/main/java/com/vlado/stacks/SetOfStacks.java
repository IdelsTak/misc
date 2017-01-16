package com.vlado.stacks;

import java.util.EmptyStackException;
import java.util.Stack;

public class SetOfStacks {

    public static void main(String[] args) {
        SetOfStacks stack = new SetOfStacks();
        System.out.println(stack);
        stack.push(1);
        System.out.println(stack);
        stack.push(2);
        System.out.println(stack);
        stack.push(3);
        System.out.println(stack);
        stack.push(4);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        stack.pop(); //will throw an EmptyStackException
    }

    private static final int THRESHOLD = 3;
    Stack<Stack<Integer>> stacks;

    public SetOfStacks() {
        stacks = new Stack<Stack<Integer>>();
    }

    public void push(int value) {
        Stack<Integer> stack = getLastStack();
        if (stack != null && stack.size() < THRESHOLD) {
            stack.push(value);
        } else {
            Stack<Integer> newStack = new Stack<Integer>();
            newStack.push(value);
            stacks.push(newStack);
        }
    }

    public int pop() {
        Stack<Integer> last = getLastStack();
        if (last == null) {
            throw new EmptyStackException();
        }
        int value = last.pop();
        if (last.size() == 0) {
            stacks.pop();
        }
        return value;
    }

    private Stack<Integer> getLastStack() {
        if (stacks.isEmpty()) {
            return null;
        }
        return stacks.peek();
    }

    @Override
    public String toString() {
        return "Number of stacks: " + stacks.size();
    }
}
