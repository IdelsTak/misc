package com.vlado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CapitalDistance {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CapitalDistance().solution(new int[]{9, 1, 4, 9, 0, 4, 8, 9, 0, 1})));
    }


    public int[] solution(int[] arr) {
        LinkedList<Integer>[] connections = new LinkedList[arr.length];
        for (int i = 0; i < connections.length; i++) {
            connections[i] = new LinkedList<>();
        }

        int root = -1;

        for (int i = 0; i < arr.length; i++) {
            if (i != arr[i]) {
                connections[i].add(arr[i]);
                connections[arr[i]].add(i);
            } else {
                root = i;
            }
        }

        if (root == -1) {
            throw new RuntimeException("No capital found");
        }

        LinkedList<Integer> rootConnections = connections[root];
        int[] result = new int[arr.length - 1];
        int level = 0;

        Queue<LinkedList<Integer>> queue = new LinkedList<>();
        queue.add(rootConnections);
        while (!queue.isEmpty()) {
            LinkedList<Integer> poll = queue.poll();
            for (int i = 0; i < poll.size(); i++) {
                Integer integer = poll.get(i);
                if (arr[integer] != -1) {
                    queue.add(connections[integer]);
                    result[level] ++;
                }
                arr[integer] = -1;
            }
            level++;
        }

        return result;
    }
}
