package com.vlado;

import java.util.*;

public class SurroundedRegions {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solve(board);
        print(board);

        board = new char[][]{
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'}
        };
        solve(board);
        print(board);

        board = new char[][]{
                {'X', 'X', 'X'},
                {'X', 'O', 'X'},
                {'X', 'X', 'X'}
        };
        solve(board);
        print(board);

        board = new char[][]{
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'},
        };
        solve(board);
        print(board);

//        int a = 89;
//        int b = 167;
//
//        int c = a << 16 | b;
//        System.out.println(c >> 16);
//        System.out.println(c & 0x0000FFFF);
//
//        long d = a << 32 | b;
//        System.out.println((int)a >> 32);
//        System.out.println((int)b);
    }

    private static void print(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println();
    }

    public static void solve(char[][] board) {
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[i].length - 1; j++) {
                if (board[i][j] == 'O') {
                    bfsFill(board, i, j);
                }
            }
        }
    }

    private static void bfsFill(char[][] grid, int x, int y) {
        int n = grid.length;
        int m = grid[0].length;

        LinkedList<Pair> queue = new LinkedList<Pair>();
        Set<Pair> elementsToTransform = new HashSet<Pair>();

        Pair init = new Pair(x, y);
        queue.offer(init);
        elementsToTransform.add(init);

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int i = pair.i;
            int j = pair.j;

            if (grid[i - 1][j] == 'O') {
                Pair p = new Pair(i - 1, j);
                if (p.isBorder(m, n)) {
                    elementsToTransform = null;
                    break;
                }
                if (!elementsToTransform.contains(p)) {
                    queue.offer(p);
                    elementsToTransform.add(p);
                }
            }
            if (grid[i + 1][j] == 'O') {
                Pair p = new Pair(i + 1, j);
                if (p.isBorder(m, n)) {
                    elementsToTransform = null;
                    break;
                }

                if (!elementsToTransform.contains(p)) {
                    queue.offer(p);
                    elementsToTransform.add(p);
                }
            }
            if (grid[i][j - 1] == 'O') {
                Pair p = new Pair(i, j - 1);
                if (p.isBorder(m, n)) {
                    elementsToTransform = null;
                    break;
                }

                if (!elementsToTransform.contains(p)) {
                    queue.offer(p);
                    elementsToTransform.add(p);
                }
            }
            if (grid[i][j + 1] == 'O') {
                Pair p = new Pair(i, j + 1);
                if (p.isBorder(m, n)) {
                    elementsToTransform = null;
                    break;
                }

                if (!elementsToTransform.contains(p)) {
                    queue.offer(p);
                    elementsToTransform.add(p);
                }
            }
        }

        if (elementsToTransform != null) {
            for (Pair p : elementsToTransform) {
                grid[p.i][p.j] = 'X';
            }
        }
    }

    static class Pair {

        public final int i;
        public final int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public boolean isBorder(int m, int n) {
            return i == 0 || j == 0 || i == m - 1 || j == n - 1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (i != pair.i) return false;
            return j == pair.j;

        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }
    }
}
