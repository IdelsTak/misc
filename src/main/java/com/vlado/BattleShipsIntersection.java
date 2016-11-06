package com.vlado;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BattleShipsIntersection {

    public static void main(String[] args) {
        System.out.println(solution(4, "1B 2C,2D 4D", "2B 2D 3D 4D 4A")); //should be 1,1
    }

    public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String solution(int map, String positions, String hits) {
        Map<Coordinate, Ship> ships = new HashMap<Coordinate, Ship>();

        String[] shipCoordinates = positions.split(",");
        for (String coordinates : shipCoordinates) {
            Ship ship = new Ship(coordinates);
            for (Coordinate singleCoordinate : ship.getCoordinates()) {
                ships.put(singleCoordinate, ship);
            }
        }

        String[] singleHits = hits.split(" ");
        for (String singleHit : singleHits) {
            Coordinate hit = new Coordinate(Integer.parseInt(singleHit.replaceAll("[^\\d.]", "")),
                    singleHit.charAt(singleHit.length() - 1) - 'A' + 1);
            Ship ship = ships.get(hit);
            if (ship != null) {
                ship.destroy(hit);
            }
        }

        int destroyed = 0;
        int hit = 0;
        Set<Ship> shipSet = new HashSet<Ship>(ships.values());
        for (Ship s : shipSet) {
            if (s.isDestroyed()) {
                destroyed ++;
            } else if (s.isHit()) {
                hit ++;
            }
        }

        return String.format("%d,%d", destroyed, hit);
    }

    public static class Ship {
        Set<Coordinate> coordinates = new HashSet<Coordinate>();
        boolean isHit = false;

        public Ship(String coordinateString) {
            String[] split = coordinateString.split(" ");

            int xDiff = split[0].charAt(split[0].length() - 1) - split[1].charAt(split[1].length() - 1);
            int yDiff = Integer.parseInt(split[0].replaceAll("[^\\d.]", "")) - Integer.parseInt(split[0].replaceAll("[^\\d" +
                    ".]", ""));

            for (int i = alphabet.indexOf(split[0].charAt(split[0].length() - 1) + 1); i <= alphabet.indexOf(split[1]
                    .charAt(split[1].length() - 1) + 1); i++) {
                for (int j = Integer.parseInt(split[0].replaceAll("[^\\d.]", "")); j <= Integer.parseInt(split[1]
                        .replaceAll("[^\\d" +
                        ".]", "")); j++) {
                    coordinates.add(new Coordinate(j, i));
                }
            }
        }

        public boolean destroy(Coordinate coordinate) {
            isHit = true;
            return coordinates.remove(coordinate);
        }

        public Set<Coordinate> getCoordinates() {
            return coordinates;
        }

        public boolean isHit() {
            return isHit;
        }

        public boolean isDestroyed() {
            return coordinates.size() == 0;
        }
    }

    public static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "[" + x + "," + y + "]";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Coordinate that = (Coordinate) o;

            if (x != that.x) return false;
            return y == that.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

}
