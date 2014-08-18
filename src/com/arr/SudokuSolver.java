package com.arr;

import java.util.Arrays;

public class SudokuSolver {
    /**
     * Write a program to solve a Sudoku puzzle by filling the empty cells.
     * Empty cells are indicated by the character '.'.
     * You may assume that there will be only one unique solution.
     */
    public static void main(String[] args) {
        char[][] board={"..9748...".toCharArray(),
                        "7........".toCharArray(),
                        ".2.1.9...".toCharArray(),
                        "..7...24.".toCharArray(),
                        ".64.1.59.".toCharArray(),
                        ".98...3..".toCharArray(),
                        "...8.3.2.".toCharArray(),
                        "........6".toCharArray(),
                        "...2759..".toCharArray()};
        solveSudoku(board);
        for(char[] c:board){
            System.out.println(Arrays.toString(c));
        }
    }
    public static void solveSudoku(char[][] board) {
        dfs(board);
    }
    private static boolean dfs(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(int k=1;k<10;k++){
                        board[i][j]= (char)(k+'0');
                        if(isValid(board, i, j) && dfs(board)){
                            return true;
                        }
                        board[i][j]='.';
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean isValid(char[][] board,int a,int b){
        for(int i=0;i<9;i++){
            if(i!=a && board[i][b]==board[a][b]){
                return false;
            }
        }
        for(int j=0;j<9;j++){
            if(j!=b && board[a][j]==board[a][b]){
                return false;
            }
        }
        int x=a/3*3,y=b/3*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(x+i != a && y+j!=b && board[x+i][y+j]==board[a][b]){
                    return false;
                }
            }
        }
        return true;
    }
}
