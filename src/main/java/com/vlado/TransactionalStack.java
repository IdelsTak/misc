package com.vlado;

import java.util.Stack;

public class TransactionalStack {

    private Stack<Integer> content;
    private Stack<TransactionalStack> transactions;

    public TransactionalStack() {
        this(false);
    }

    private TransactionalStack(boolean internal) {
        content = new Stack<Integer>();
        if (!internal) {
            transactions = new Stack<TransactionalStack>();
            transactions.push(this);
        }
    }

    public void beginTransaction() {
        TransactionalStack tx = new TransactionalStack();
        tx.content = (Stack<Integer>)content.clone();
        transactions.add(tx);
    }

    public void commitTransaction() {
        TransactionalStack lastTx = transactions.peek();
        if (lastTx != this) {
            lastTx = transactions.pop();
            transactions.peek().content = lastTx.content;
        }
    }

    public void rollbackTransaction() {
        TransactionalStack lastTx = transactions.peek();
        if (lastTx != this) {
            transactions.peek();
        }
    }

    public Integer pop() {
        return transactions.peek().pop();
    }

    public Integer push(Integer item) {
        return transactions.peek().push(item);
    }

    public Integer peek() {
        return transactions.peek().peek();
    }

    public static void main(String[] args) {
        TransactionalStack stack = new TransactionalStack();
    }
}
