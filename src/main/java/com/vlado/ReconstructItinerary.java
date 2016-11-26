package com.vlado;

import java.util.*;

public class ReconstructItinerary {

    public static void main(String[] args) {
        System.out.println(new ReconstructItinerary().findItinerary(new String[][]{
                {"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}}));
        System.out.println(new ReconstructItinerary().findItinerary(new String[][] {
                {"JFK","SFO"},{"JFK","ATL"}, {"SFO","ATL"}, {"ATL","JFK"},{"ATL","SFO"}}));
    }

    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> result = new LinkedList<>();
        Map<String, PriorityQueue<String>> flights = new HashMap<>();
        for (String[] flight : tickets) {
            flights.putIfAbsent(flight[0], new PriorityQueue<String>());
            flights.get(flight[0]).add(flight[1]);
        }
        dfs("JFK", flights, result);
        return result;
    }

    public void dfs(String departure, Map<String, PriorityQueue<String>> flights, LinkedList<String> result) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while(arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll(), flights, result);
        }
        result.addFirst(departure);
    }

}
