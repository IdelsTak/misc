package com.vlado;

import java.util.Arrays;

public class SudokuSolver {

    public static void main(String[] args) {
        String[] stringarr = new String[]{"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..",
                "...8.3.2.","........6","...2759.."};
        char[][] input = new char[9][9];
        for (int i = 0; i < 9 ; i++) {
            input[i] = stringarr[i].toCharArray();
        }

        print(input);
        new SudokuSolver().solve(input);
        print(input);
    }

    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }

    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
                        if(isValid(board, i, j, c)){ //is this combination valid
                            board[i][j] = c; //Put c for this cell
                            if(solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }

    public static void print(char[][] arr) {
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
    }
}
