package com.vlado;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<Integer>();

        if (matrix.length == 0) {
            return result;
        }

        int i, k = 0, l = 0, m = matrix.length, n = matrix[0].length;

//    k - starting row index
//    m - ending row index

//    l - starting column index
//    n - ending column index

        while (k < m && l < n) {
            for (i = l; i < n; i ++) {
                result.add(matrix[k][i]);
            }
            k++;
            for (i = k; i < m; i ++) {
                result.add(matrix[i][n - 1]);
            }
            n--;

            if (k < m) {
                for (i = n - 1; i >= l; i--) {
                    result.add(matrix[m - 1][i]);
                }
                m--;
            }

            if (l < n) {
                for (i = m - 1; i >= k; i--) {
                    result.add(matrix[i][l]);
                }
                l++;
            }
        }

        return result;
    }
}
