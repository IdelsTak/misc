package com.vlado;

public class SpiralMatrixGenerate {

    public static void main(String[] args) {
        System.out.println(generateMatrix(3));
    }

    public static int[][] generateMatrix(int size) {
        int[][] result = new int[size][size];
        if (size == 0) {
            return result;
        }

        //    k - starting row index
        //    m - ending row index

        //    l - starting column index
        //    n - ending column index
        int i, k = 0, l = 0, m = size, n = size;
        int counter = 1;

        while (k < m && l < n) {
            for (i = l; i < n; i++, counter++) {
                result[k][i] = counter;
            }
            k++;
            for (i = k; i < m; i++, counter++) {
                result[i][n - 1] = counter;
            }
            n--;

            if (k < m) {
                for (i = n - 1; i >= l; i--, counter++) {
                    result[m - 1][i] = counter;
                }
                m--;
            }

            if (l < n) {
                for (i = m - 1; i >= k; i--, counter++) {
                    result[i][l] = counter;
                }
                l++;
            }
        }

        return result;

    }
}
