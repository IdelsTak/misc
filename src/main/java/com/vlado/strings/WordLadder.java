package com.vlado.strings;

import static com.vlado.strings.WordLadder.State.UNVISITED;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 */
public class WordLadder {

  public static void main(String[] args) {
    String[] strings = {"hot", "dot", "dog", "lot", "log", "cog"};
    List<String> stringList = new ArrayList<>(strings.length + 1);
    Arrays.stream(strings).forEach(stringList::add);

    System.out.println(new WordLadder().ladderLength("hit", "cog", stringList));
  }
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Node beginNode = new Node(beginWord, 0);
    wordList.add(endWord);

    Queue<Node> q = new LinkedList<>();
    q.add(beginNode);
    while (!q.isEmpty()) {
      Node n = q.poll();
      Iterator<String> iterator = wordList.iterator();
      while (iterator.hasNext()) {
        String next = iterator.next();
        if (diff(n.word, next) == 1) {
          if (next.equals(endWord)) {
            return n.changes + 2;
          }
          Node newNode = new Node(next, n.changes + 1);
          n.addSibling(newNode);
          iterator.remove();
          q.add(newNode);
        }
      }
    }
    return -1;
  }

  private Graph buildGraph(Node beginNode, List<String> wordList) {
    Graph g = new Graph();

    Queue<Node> q = new LinkedList<>();
    q.add(beginNode);
    while (!q.isEmpty()) {
      Node n = q.poll();
      Iterator<String> iterator = wordList.iterator();
      while (iterator.hasNext()) {
        String next = iterator.next();
        if (diff(n.word, next) == 1) {
          Node newNode = new Node(next, n.changes + 1);
          n.addSibling(newNode);
          iterator.remove();
          q.add(newNode);
        }
      }
    }
    return g;
  }

  private int diff(String w1, String w2) {
    int length = Math.min(w1.length(), w2.length());
    int diffs = 0;
    for (int i = 0; i < length; i++) {
      if (w1.charAt(i) != w2.charAt(i)) {
        diffs ++;
      }
    }
    return diffs;
  }

  static class Graph {
    public Set<Node> nodes = new HashSet<>();

    void addNode(Node n) {
      this.nodes.add(n);
    }

    void addNodes(Set<Node> nodes) {
      this.nodes.addAll(nodes);
    }
  }

  public enum State {
    UNVISITED, VISITING, VISITED;
  }

  static class Node {

    public final String word;
    public final State state;
    public final int changes;
    Set<Node> siblings = new HashSet<>();

    public Node (String word, int changes) {
      this.word = word;
      state = UNVISITED;
      this.changes = changes;
    }

    public void addSibling(Node n) {
      siblings.add(n);
    }

    @Override
    public String toString() {
      return word + " [" + changes + "]";
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      Node node = (Node) o;

      return word.equals(node.word);
    }

    @Override
    public int hashCode() {
      return word.hashCode();
    }
  }
}
