package com.vlado.arrays;

/**
 * Write an algorithm such that if an element within a matrix is 0,
 * its entire row and column should be set to 0
 */
public class ZeroMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,0,6},{7,8,9}};
        new ZeroMatrix().setZeros(matrix);
        printMatrix(matrix);
    }

    void setZeros(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        for (int i = 0; i < rows.length; i++) {
            if (rows[i]) {
                nullifyColumn(i, matrix);
            }
        }

        for (int i = 0; i < columns.length; i++) {
            if (columns[i]) {
                nullifyRow(i, matrix);
            }
        }
    }

    private void nullifyRow(int row, int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    private void nullifyColumn(int column, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
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
