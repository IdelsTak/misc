package com.vlado.stacks;

import java.util.Stack;

public class StackMin extends Stack<StackMin.NodeWithMin> {

    public static void main(String[] args) {
        StackMin stack = new StackMin();
        stack.push(5);
        System.out.println(stack.min());//min is 5
        stack.push(6);
        System.out.println(stack.min());//min is 5
        stack.push(3);
        System.out.println(stack.min());//min is 3
        stack.push(7);
        System.out.println(stack.min());//min is 3
        stack.pop();
        System.out.println(stack.min());//min is 3
        stack.pop();
        System.out.println(stack.min());//min is 5
    }

    public void push(int value) {
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }

    public int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        } else{
            return this.peek().min;
        }
    }

    class NodeWithMin {
        private int value;
        private int min;

        public NodeWithMin(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }
}
