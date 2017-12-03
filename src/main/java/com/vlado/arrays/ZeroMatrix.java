package com.vlado.arrays;

/**
 * Write an algorithm such that if an element within a matrix is 0,
 * its entire row and column should be set to 0
 */
public class ZeroMatrix {

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{1,2,3},{4,0,6},{7,8,9}};
        int[][] matrix = new int[][]{{0, 1}};
        new ZeroMatrix().setZeros(matrix);
        printMatrix(matrix);
    }

    void setZeros(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        for(int i = 0 ; i < matrix.length; i++) {
            for(int j = 0 ; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for(int i = 0 ; i < matrix.length; i++) {
            for(int j = 0 ; j < matrix[0].length; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    static void printMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
}
