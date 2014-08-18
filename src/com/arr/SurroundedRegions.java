package com.arr;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    /**
     * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
     * A region is captured by flipping all 'O's into 'X's in that surrounded region. 
     * For example, 
     * X X X X 
     * X O O X 
     * X X O X 
     * X O X X 
     * After running your function, the board should be: 
     * X X X X 
     * X X X X 
     * X X X X 
     * X O X X
     */
    
    public static void main(String[] args) {
        char[][] board =
                { {'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'},
                        {'X', 'O', 'X', 'X'}};
        new SurroundedRegions().solve(board);
        for (char[] arr : board) {
            System.out.println(Arrays.toString(arr));
        }
    }

    //方法一     未通过 java.lang.StackOverflowError
    int m, n;
    char[][] board;
    private void dfs(int x, int y) {
        if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {//扫描范围必须在矩阵内，扫到'O'时，向四周扩散
            board[x][y] = 'D';
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
        }
    }
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        this.board = board;
        m = board.length;//行
        n = board[0].length;//列
        for (int j = 0; j < n; j++) {
            dfs(0, j);//第一行
            dfs(m - 1, j);//最后一行
        }
        for (int i = 1; i < m - 1; i++) {
            dfs(i, 0);//第一列(扣除第一行和最后一行)
            dfs(i, n - 1);//最后一列(扣除第一行和最后一行)
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'D') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    
    //方法二     通过
    public void solve1(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int m = board.length;//行
        if (m == 0) return;
        int n = board[0].length;//列
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0, m, n);
            dfs(board, i, n - 1, m, n);
        }
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j, m, n);
            dfs(board, m - 1, j, m, n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if (board[i][j] == '#'){ 
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void dfs(char[][] board, int i, int j, int m, int n) {
        Queue<int[]> queue = new LinkedList<int[]>();
        enqueue(queue, i, j, board, m, n);
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int ii = curr[0];
            int jj = curr[1];
            enqueue(queue, ii - 1, jj, board, m, n);
            enqueue(queue, ii + 1, jj, board, m, n);
            enqueue(queue, ii, jj - 1, board, m, n);
            enqueue(queue, ii, jj + 1, board, m, n);
        }
    }
    public void enqueue(Queue<int[]> queue, int i, int j, char[][] board, int m, int n) {
        if (!isValid(board, i, j, m, n)) return;
        int[] pair = new int[2];
        pair[0] = i;
        pair[1] = j;
        board[i][j] = '#';
        queue.offer(pair);
    }

    public boolean isValid(char[][] board, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        return board[i][j] == 'O';
    }
}
