package com.vlado;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class AlienDictionary {

    public static void main(String[] args) {
        System.out.println(new AlienDictionary().alienOrder(new String[]{
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"}));
    }

    int[][] graph;

    public String alienOrder(String[] words) {

        Set<Character> chars = new HashSet<>();
        for (String s : words) {
            for (char c : s.toCharArray()) {
                chars.add(c);
            }
        }

        init();

        fill(Arrays.asList(words));

        int[] topsort = topsort();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (topsort[j] == i && chars.contains(Character.valueOf((char) (j + 'a')))) {
//                    System.out.print((char) (j + 'a'));
                    sb.append((char) (j + 'a'));
                }
            }
        }

        return sb.toString();
    }

    private void fill(List<String> data) {
        if (data.isEmpty()) {
            return;
        }

        for (int i = 0; i < data.size(); i++) {
            String s = data.get(i);

            for (int j = i + 1; j < data.size(); j++) {
                String next = data.get(j);

                char c1 = s.charAt(0);
                char c2 = next.charAt(0);
                if (c1 == c2) {
                    continue;
                }
                // System.out.println(c1 + " < " + c2);
                before(c1, c2);
            }
        }
        //w < e < r < t < f
        Map<Character, List<String>> collect = data.stream()
                .map(s -> s.substring(1))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.groupingBy(s -> s.charAt(0), LinkedHashMap::new, Collectors.toList()));

        List<String> keys = collect.keySet().stream()
                .map(Object::toString)
                .collect(Collectors.toList());

        fill(keys);

        for (List<String> unprefixed : collect.values()) {
            fill(unprefixed);
        }
    }

    void init() {
        graph = new int[26][26];
        for (int i = 0; i < 26; i++) {
            graph[i][i] = 1;
        }
    }

    void before(char a, char b) {
        graph[a - 'a'][b - 'a'] = 1;
    }

    private int[] topsort() {
        AtomicInteger counter = new AtomicInteger(-1);
        int[] nums = new int[26];
        boolean[] visited = new boolean[26];

        for (int i = 0; i < 26; i++) {
            if (!visited[i]) {
                dfs(i, nums, visited, counter);
            }
        }

        return nums;
    }

    private void dfs(int source, int[] nums, boolean[] visited, AtomicInteger counter) {
        visited[source] = true;

        for (int i = 0; i < 26; i++) {
            int exist = graph[i][source];
            if (exist == 1 && !visited[i]) {
                dfs(i, nums, visited, counter);
            }
        }
        nums[source] = counter.incrementAndGet();
    }
}
