package com.vlado.datastructs;

import java.util.*;
import java.util.ArrayList;

/**
 * Created by vdimitrov on 7/11/17.
 */
public class Trie {

    private Vertex root = new Vertex(null);

    public void insert(String word) {
        root.insert(word);
    }

    // Returns if there is any word in the trie
    public boolean search(String word) {
        Vertex vertex = getVertexStartingWithPrefix(word);
        return vertex != null && vertex.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        Vertex currentVertex = getVertexStartingWithPrefix(prefix);
        if (currentVertex != null) {
            Queue<Vertex> q = new LinkedList<>();
            q.add(currentVertex);
            while (!q.isEmpty()) {
                Vertex vertex = q.poll();
                if (vertex != null) {
                    if (vertex.isWord) {
                        return true;
                    }
                    Vertex[] edges = vertex.edges();
                    Collections.addAll(q, edges);
                }
            }
        }
        return false;
    }

    public List<String> startsWith(String prefix, int maxCount) {
        List<String> result = new LinkedList<>();
        Vertex currentVertex = getVertexStartingWithPrefix(prefix);
        Queue<Vertex> q = new LinkedList<>();
        q.add(currentVertex);
        int internalCounter = 0;
        while (!q.isEmpty() && internalCounter < maxCount) {
            Vertex vertex = q.poll();
            if (vertex != null) {
                if (vertex.isWord) {
                    internalCounter++;
                    result.add(prefix + vertex.word);
                }
                Vertex[] edges = vertex.edges();
                Collections.addAll(q, edges);
            }
        }
        return result;
    }

    private Vertex getVertexStartingWithPrefix(String prefix) {
        Vertex currentVertex = root;
        for (Character c : prefix.toCharArray()) {
            if (currentVertex == null) {
                return null;
            }
            currentVertex = currentVertex.edge(c - 'a');
        }
        return currentVertex;
    }

    class Vertex {
        public Vertex[] edges = new Vertex[26];
        public boolean isWord = false;
        public String word;

        public Vertex(String word) {
            this.word = word;
        }

        public Vertex edge(int index) {
            return edges[index];
        }

        public void insert(String word) {
            if(word != null && word.length() > 0) {
                char c = word.charAt(0);
                int index = c - 'a';
                Vertex vertex = createOrGet(index, word);
                if (word.length() == 1) {
                    vertex.isWord = true;
                }
                vertex.insert(word.substring(1));
                edges[index] = vertex;
            }
        }

        public Vertex[] edges() {
            return edges;
        }

        public Vertex createOrGet(int index, String word) {
            return edges[index] == null ? new Vertex(word) : edges[index];
        }
    }
}
