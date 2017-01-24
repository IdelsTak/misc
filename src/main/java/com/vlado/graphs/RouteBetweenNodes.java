package com.vlado.graphs;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Given a directed graph, design an algorithm to find out
 * whether there is a route between two nodes.
 */
public class RouteBetweenNodes {

    public static void main(String[] args) {
        Graph g = new Graph();
        Graph.Node n1 = g.addNode("n1");
        Graph.Node n2 = g.addNode("n2");
        Graph.Node n3 = g.addNode("n3");
        Graph.Node n4 = g.addNode("n4");
        Graph.Node n5 = g.addNode("n5");

        n1.addEdgeTo(n2);
        n2.addEdgeTo(n3);
        n3.addEdgeTo(n1);
        n2.addEdgeTo(n4);

        System.out.println(new RouteBetweenNodes().search(g, n1, n4));//true
        System.out.println(new RouteBetweenNodes().search(g, n1, n5));//false
    }

    boolean search(Graph g, Graph.Node start, Graph.Node end) {
        if (start == end) {
            return true;
        }
        Collection<Graph.Node> nodes = g.getNodes();
        for (Graph.Node n : nodes) {
            n.state = Graph.State.Unvisited;
        }

        LinkedList<Graph.Node> q = new LinkedList<>();
        start.state = Graph.State.Visiting;
        q.add(start);

        while (!q.isEmpty()) {
            Graph.Node u = q.removeFirst();
            if (u != null) {
                for (Graph.Node n : u.getAdjacent()) {
                    if (n.state == Graph.State.Unvisited) {
                        if (n == end) {
                            return true;
                        } else {
                            n.state = Graph.State.Visiting;
                            q.add(n);
                        }
                    }
                }
                u.state = Graph.State.Visited;
            }
        }
        return false;
    }
}
