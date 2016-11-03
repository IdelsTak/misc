package com.vlado;

import java.util.*;

/**
 * Created by vdimitrov on 10/26/16.
 */
public class Election {

    public static void main(String[] args) {
        String[] candidates = new String[]{"Alex", "Michael", "Harry", "Dave", "Michael", "Victor", "Harry", "Alex",
                "Marry", "Marry"};
        System.out.println(Election.elect(candidates));
        //Should return Michael
    }

    public static String elect(String[] candidates) {
        HashMap<String, Candidate> hashMap = new HashMap<String, Candidate>();

        for (String s : candidates) {
            Candidate c = hashMap.get(s);
            if (c == null) {
                c = new Candidate(s);
                hashMap.put(s, c);
            } else {
                c.increaseVoteByOne();
            }
        }

        PriorityQueue<Candidate> q = new PriorityQueue<Candidate>(hashMap.size());
        Collection<Candidate> candidateCollection = hashMap.values();
        for (Candidate c : candidateCollection) {
            q.add(c);
        }

        return q.poll().name;
    }

    public static class Candidate implements Comparable<Candidate> {

        public String name;
        public Integer votes = 1;

        public Candidate(String name) {
            this.name = name;
        }

        public void increaseVoteByOne() {
            votes += 1;
        }

        public int compareTo(Candidate o) {
            int v = o.votes.compareTo(votes);
            if (v != 0) return v;

            return o.name.compareTo(name);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Candidate)) {
                return false;
            }
            Candidate other = (Candidate) obj;

            return this.name.equals(other.name);
        }
    }

}
